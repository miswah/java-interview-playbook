The Challenge: Conditional Race (The Budget Flight Finder)

Standard scopes like ShutdownOnSuccess (or Joiner.awaitFirstSuccessful()) return the very first task that completes without an exception. But in the real world, "fastest" isn't always "best."
The Business Requirements:

You are building a real-time flight aggregator. When a user searches for a flight, they provide a strict maximum budget. You must query several airline APIs concurrently to find a flight.

    The Goal: Return the fastest successful quote that is strictly less than or equal to the user's budget.

    The Catch: * If Airline A returns quickly but the price is over budget, you must ignore it and keep waiting for the others.

        If Airline B throws an ApiTimeoutException, ignore it and keep waiting.

        The exact millisecond an airline returns a quote that is under budget, you must capture it, instantly cancel all remaining pending airline queries, and return the quote.

    Failure State: If all queries finish and none of them are under budget (or they all failed), the scope must throw a NoAffordableFlightException.

**The Scaffolding (Do not modify this)**
```Java

import java.util.concurrent.StructuredTaskScope;

// Data Model
public record FlightQuote(String airline, String flightNumber, double price) {}

public class NoAffordableFlightException extends RuntimeException {
    public NoAffordableFlightException(String message) { super(message); }
}

// External Service Stub
public interface AirlineAPI {
    // Simulates a network call. May take 10ms to 5000ms. May throw an exception.
    FlightQuote fetchQuote(String source, String destination) throws Exception;
}

// The Orchestrator Class
public class FlightAggregator {
    
    private final AirlineAPI deltaApi;
    private final AirlineAPI unitedApi;
    private final AirlineAPI jetblueApi;
    private final AirlineAPI southwestApi;

    public FlightAggregator(AirlineAPI delta, AirlineAPI united, AirlineAPI jetblue, AirlineAPI southwest) {
        this.deltaApi = delta;
        this.unitedApi = united;
        this.jetblueApi = jetblue;
        this.southwestApi = southwest;
    }

    // YOUR JOB: Implement this method and any required inner classes/joiners
    public FlightQuote findFastestAffordableFlight(String src, String dest, double maxBudget) {
        // TODO: Implement using a custom StructuredTaskScope / Joiner
        return null; 
    }
}
```

**Your Deliverable:**

Write the implementation for findFastestAffordableFlight and the custom Joiner (or StructuredTaskScope subclass, depending on which Java preview version you are targeting) required to make this conditional short-circuiting work.
