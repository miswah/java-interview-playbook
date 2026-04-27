import java.util.concurrent.ThreadLocalRandom;

public class AirlineAPI {
    // Simulates a network call. May take 10ms to 5000ms. May throw an exception.
    public FlightQuote fetchQuote(String source, String destination) throws Exception {
        int delay = ThreadLocalRandom.current().nextInt(10, 5001);
        Thread.sleep(delay);

        if(ThreadLocalRandom.current().nextInt(100) < 20){
            throw new Exception("Network error while fetching quote");
        }

        int price = ThreadLocalRandom.current().nextInt(20, 70);
        return new FlightQuote(source, destination, price);
    }
}
