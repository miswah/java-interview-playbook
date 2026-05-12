import java.util.List;

public class TransactionDatabase {
    public void saveAll(List<Transaction> transactions) {
        System.out.println("Saving " + transactions.size() + " transactions to DB...");
        transactions.forEach(tx -> System.out.println(" -> Inserted: " + tx));
    }
}