
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aggregator {

    private final DownstreamServices service;

    public Aggregator(DownstreamServices service){
        this.service = service;
    }

    public Main.UserProfile getFullProfile(String userId){

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            CompletableFuture<Main.UserDetails> userDetailsFuture = CompletableFuture.supplyAsync(() ->
                    this.service.fetchUserDetails(userId), executor);

            CompletableFuture<List<Main.UserOrder>> userOrderFuture = CompletableFuture.supplyAsync(() ->
                    this.service.fetchUserOrders(userId), executor);

            CompletableFuture<List<Main.UserRecommendation>> userRecommendationFuture = CompletableFuture.supplyAsync(() ->
                    this.service.fetchUserRecommendations(userId), executor)
                    .exceptionally(ex -> {
                        System.out.println("Error while calling fetch recommendation defaulting to fallback");
                        return List.of();
                    });

            //This is not needed as block a VT is not a heavy task we can use join() for each of the futures
//            CompletableFuture<Main.UserProfile> userProfile = CompletableFuture.allOf(userDetailsFuture, userOrderFuture, userRecommendationFuture).thenApply(voidResult -> {
//                Main.UserDetails userDetails = userDetailsFuture.join();
//                List<Main.UserOrder> userOrders = userOrderFuture.join();
//                List<Main.UserRecommendation> userRecommendations = userRecommendationFuture.join();
//
//                return new Main.UserProfile(userDetails, userOrders, userRecommendations);
//            });

            //join() blocks the thread but block vt is not a heavy task each of the future is in a separate VT
            Main.UserDetails userDetails = userDetailsFuture.join();
            List<Main.UserOrder> userOrders = userOrderFuture.join();
            List<Main.UserRecommendation> userRecommendations = userRecommendationFuture.join();

            return new Main.UserProfile(userDetails, userOrders, userRecommendations);
        }
    }
}
