import java.util.List;
import java.util.stream.Collectors;

public abstract class DataProcessor {

    // Dependency injected or instantiated for the shared step
    private final TransactionDatabase database = new TransactionDatabase();

    public final void processFile(String source) {
        String rawData = readData(source);

        List<Transaction> transactions = parseData(rawData);

        List<Transaction> validTransactions = transactions.stream()
                .filter(tx -> tx.amount() >= 0)
                .collect(Collectors.toList());

        database.saveAll(validTransactions);

        postProcessing();
    }

    protected abstract String readData(String source);
    protected abstract List<Transaction> parseData(String rawData);

    // HOOK
    protected void postProcessing() {
        // Default implementation does nothing.
    }
}