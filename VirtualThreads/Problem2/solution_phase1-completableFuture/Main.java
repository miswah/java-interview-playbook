import java.io.IOException;
import java.util.List;


public class Main {

    public record UserDetails(String userId, String name, String email) {}

    public record UserOrder(String orderId, double totalAmount, String status) {}

    public record UserRecommendation(String productId, String personalizedReason) {}

    // The final aggregated result
    public record UserProfile(
            UserDetails details,
            List<UserOrder> orders,
            List<UserRecommendation> recommendations
    ) {}

    public static void main(String[] args) throws IOException {
        Aggregator ag = new Aggregator(new DownstreamServicesImpl());

        System.out.println(ag.getFullProfile("1"));
    }
}