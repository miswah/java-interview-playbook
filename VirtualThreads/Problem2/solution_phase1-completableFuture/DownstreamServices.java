import java.util.List;

public interface DownstreamServices {

    // Simulates a 500ms network call
    Main.UserDetails fetchUserDetails(String userId);

    // Simulates a 2000ms network call
    List<Main.UserOrder> fetchUserOrders(String userId);

    // Simulates a 1000ms network call. 
    // MUST throw a RuntimeException 50% of the time.
    List<Main.UserRecommendation> fetchUserRecommendations(String userId);
}