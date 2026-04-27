import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightAggregatorScope implements StructuredTaskScope.Joiner<FlightQuote, FlightQuote> {
    private final double maxBudget;
    private final int totalTasks;

    private final AtomicInteger completedTasks = new AtomicInteger(0);
    private volatile FlightQuote winningQuote = null;

    public FlightAggregatorScope(double maxPrice, int totalTasks){
        maxBudget = maxPrice;
        this.totalTasks = totalTasks;
    }

    @Override
    public boolean onComplete(StructuredTaskScope.Subtask<FlightQuote> subtask) {
        if (subtask.state() == StructuredTaskScope.Subtask.State.SUCCESS){
            FlightQuote quote = subtask.get();

            if(quote.price() <= maxBudget){
                if(winningQuote == null){
                    winningQuote = quote;
                }

                return true;
            }
        }

        completedTasks.incrementAndGet();
        return false;
    }

    @Override
    public FlightQuote result() throws Throwable {
        if (winningQuote != null) {
            return winningQuote; // Successfully short-circuited
        }

        // If we reach this point, all tasks completed but none triggered a short-circuit
        if (completedTasks.get() == totalTasks) {
            throw new NoAffordableFlightException("No flights found under the strict budget of $" + maxBudget);
        }

        throw new IllegalStateException("Scope joined unexpectedly without resolving all tasks.");
    }
}
