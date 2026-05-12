import java.util.List;

public class JsonDataProcessor extends DataProcessor {
    @Override
    protected String readData(String source) {
        // In reality, maybe fetch from an S3 bucket or REST API
        return "{JSON_RAW_DATA}";
    }

    @Override
    protected List<Transaction> parseData(String rawData) {
        return List.of(new Transaction("TX3", 200.0, "GBP"));
    }

    // Overriding the hook for custom behavior
    @Override
    protected void postProcessing() {
        System.out.println("Audit log: JSON processing complete.");
    }
}
