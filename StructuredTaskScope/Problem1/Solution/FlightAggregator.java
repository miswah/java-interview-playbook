import java.util.concurrent.StructuredTaskScope;

public class FlightAggregator {
    private static AirlineAPI deltaApi = new AirlineAPI();
    private static AirlineAPI unitedApi = new AirlineAPI();
    private static AirlineAPI jetblueApi = new AirlineAPI();
    private static AirlineAPI southwestApi = new AirlineAPI();

    public FlightAggregator(AirlineAPI delta, AirlineAPI united, AirlineAPI jetblue, AirlineAPI southwest) {
        deltaApi = delta;
        unitedApi = united;
        jetblueApi = jetblue;
        southwestApi = southwest;
    }

    // YOUR JOB: Implement this method and any required inner classes/joiners
    public static FlightQuote findFastestAffordableFlight(String src, String dest, double maxBudget) {
        try(var scope = StructuredTaskScope.open(new FlightAggregatorScope(maxBudget, 4))){
            scope.fork(() -> deltaApi.fetchQuote("SRC", "DEST"));
           scope.fork(() -> unitedApi.fetchQuote("SRC", "DEST"));
            scope.fork(() -> jetblueApi.fetchQuote("SRC", "DEST"));
            scope.fork(() -> southwestApi.fetchQuote("SRC", "DEST"));

            return scope.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
