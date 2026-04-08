
import java.util.List;
import java.util.concurrent.*;

public class Aggregator {

    private final DownstreamServices service;

    public Aggregator(DownstreamServices service){
        this.service = service;
    }

    public Main.UserProfile getFullProfile(String userId){

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()){
            StructuredTaskScope.Subtask<Main.UserDetails> userDetails = scope.fork(() -> this.service.fetchUserDetails(userId));

            StructuredTaskScope.Subtask<List<Main.UserOrder>> userOrders = scope.fork(() -> this.service.fetchUserOrders(userId));

            StructuredTaskScope.Subtask<List<Main.UserRecommendation>> userRecommendations = scope.fork(() -> {
                try {
                    return this.service.fetchUserRecommendations(userId);
                } catch (RuntimeException e){
                    return List.of();
                }
            });

            scope.join();
            scope.throwIfFailed();


            return new Main.UserProfile(userDetails.get(), userOrders.get(), userRecommendations.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
