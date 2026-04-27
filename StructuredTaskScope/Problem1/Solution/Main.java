import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(FlightAggregator.findFastestAffordableFlight("src", "dest", 50));
    }
}