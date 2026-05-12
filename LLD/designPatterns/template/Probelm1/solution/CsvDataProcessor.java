import java.util.List;

public class CsvDataProcessor extends DataProcessor {
    @Override
    protected String readData(String source) {
        // In reality, read from local CSV file
        return "CSV_RAW_DATA";
    }

    @Override
    protected List<Transaction> parseData(String rawData) {
        return List.of(
                new Transaction("TX1", 100.0, "USD"),
                new Transaction("TX2", -50.0, "EUR") // This will be filtered out!
        );
    }
}
