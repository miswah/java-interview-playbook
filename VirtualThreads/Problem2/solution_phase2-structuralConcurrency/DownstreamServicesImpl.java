import java.util.List;
import java.util.Random;

public class DownstreamServicesImpl implements DownstreamServices{
    @Override
    public Main.UserDetails fetchUserDetails(String userId) {
        try{
            Thread.sleep(500);
            return new Main.UserDetails(userId, "user1", "user1@gamil.com");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Main.UserOrder> fetchUserOrders(String userId) {
        try{
            Thread.sleep(2000);
           return List.of(new Main.UserOrder("1", 50.00, "Delivered"), new Main.UserOrder("2", 55.00, "Out for delivery"));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Main.UserRecommendation> fetchUserRecommendations(String userId) {
        try {
            Thread.sleep(1000);

            Random rand = new Random();
            int randomNum = rand.nextInt((10 - 1) + 1) + 1;

            if(randomNum % 2 == 0){
                throw new RuntimeException("Error happen");
            }
            return List.of(new Main.UserRecommendation("1", "reason 1"), new Main.UserRecommendation("2", "reason 2"));

        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
