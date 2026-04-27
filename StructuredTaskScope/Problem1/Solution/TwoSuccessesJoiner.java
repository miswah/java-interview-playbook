import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TwoSuccessesJoiner <T> implements StructuredTaskScope.Joiner<T, Void>{
    private final AtomicInteger successCount = new AtomicInteger(0);

    @Override
    public boolean onComplete(StructuredTaskScope.Subtask<T> subtask) {
       if(subtask.state() == StructuredTaskScope.Subtask.State.SUCCESS){
           int count = successCount.incrementAndGet();
           return count >= 2;
       }

       return false;
    }

    @Override
    public Void result() throws Throwable {
        return null;
    }
}
