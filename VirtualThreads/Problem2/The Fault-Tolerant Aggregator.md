You are building the aggregation layer of a microservice architecture. A client requests a complete UserProfile, but the data is scattered across three slow, downstream legacy services.

To meet performance requirements, you must fetch all three pieces of data concurrently. However, the downstream services are unreliable:

    Details Service: Returns basic user info. Takes exactly 500ms.

    Orders Service: Returns a list of recent orders. Takes exactly 2000ms.

    Recommendations Service: Returns a list of suggested products. Takes exactly 1000ms, but the service is flaky—it throws a RuntimeException 50% of the time.

The Aggregation Rule:
Your aggregator must be fault-tolerant. If the Details or Orders services fail (which they shouldn't in this simulation), the request can fail. But if the Recommendations service fails, the aggregator must swallow the error, gracefully recover, and return the UserProfile with an empty list of recommendations. It must not crash the entire user request.
The Data Models

Here are the Java record classes you should use to model the domain. You can copy-paste these into your project.

```java

import java.util.List;

public record UserDetails(String userId, String name, String email) {}

public record UserOrder(String orderId, double totalAmount, String status) {}

public record UserRecommendation(String productId, String personalizedReason) {}

// The final aggregated result
public record UserProfile(
    UserDetails details, 
    List<UserOrder> orders, 
    List<UserRecommendation> recommendations
) {}

```

The Service Contracts

To keep your code clean, I recommend creating a simulated client or service class with the following signature methods. You will need to write the simulation logic (Thread.sleep(), random boolean generators, etc.) inside these methods.

```java
import java.util.List;

public interface DownstreamServices {
    
    // Simulates a 500ms network call
    UserDetails fetchUserDetails(String userId);
    
    // Simulates a 2000ms network call
    List<UserOrder> fetchUserOrders(String userId);
    
    // Simulates a 1000ms network call. 
    // MUST throw a RuntimeException 50% of the time.
    List<UserRecommendation> fetchUserRecommendations(String userId);
}
```

Your Mission

You need to write an Aggregator class with a method like public UserProfile getFullProfile(String userId).

Phase 1: The CompletableFuture Approach

    Implement the aggregator using Executors.newVirtualThreadPerTaskExecutor().

    Use CompletableFuture.supplyAsync() to dispatch the tasks.

    Combine the results.

    Hint for the review: Pay close attention to how you handle the exception from the recommendation service without blocking or failing the other futures.

Phase 2: Structured Concurrency (The Challenge)

    Re-implement the aggregator using Java's StructuredTaskScope.

    Setup Warning: Depending on your JDK version (Java 21+), Structured Concurrency is a preview feature. You will need to compile and run your code with the preview flags.

        Compile: javac --release 21 --enable-preview ...

        Run: java --enable-preview ...

    Hint for the review: Think carefully about which scope policy to use (e.g., ShutdownOnFailure, ShutdownOnSuccess, or a custom scope) given that one of your tasks is allowed to fail.