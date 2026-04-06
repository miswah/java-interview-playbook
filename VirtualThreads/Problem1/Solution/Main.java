import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) throws Exception {
        List<Order> orders = List.of(
                new Order(1, 101, 500),
                new Order(2, 102, 1500),
                new Order(3, 103, 2500),
                new Order(4, 104, 3500)
        );




        enrichOrdersV2(orders);
        enrichOrdersV1(orders);

    }


    private static List<EnrichedOrder> enrichOrdersV1(List<Order> orders){
        long startTime = System.nanoTime();
       List<EnrichedOrder> list = new ArrayList<>();
        for(Order o : orders){
           User user =  ExternalServices.fetchUser(o.userId());
           Payment payment = ExternalServices.fetchPayment(o.orderId());

           list.add(new EnrichedOrder(o.orderId(), user.name(), o.amount(), payment.status()));
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Execution time in mils: " + duration / 1_000_000);
        return list;
    }

    private static List<EnrichedOrder> enrichOrdersV2(List<Order> orders){
        long startTime = System.nanoTime();


        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            List<Future<EnrichedOrder>> futures = new ArrayList<>();
            for(Order o : orders){
               futures.add(executor.submit(() -> {
                   Future<User> userFuture = executor.submit(() -> ExternalServices.fetchUser(o.userId()));

                   Future<Payment> paymentFuture = executor.submit(() -> ExternalServices.fetchPayment(o.orderId()));


                   try {
                       User user = userFuture.get();
                       Payment payment = paymentFuture.get();

                       return new EnrichedOrder(
                               o.orderId(),
                               user.name(),
                               o.amount(),
                               payment.status()
                       );
                   } catch (InterruptedException | ExecutionException e) {
                       throw new RuntimeException(e);
                   }
               }));


            }

            List<EnrichedOrder> result = new ArrayList<>();
            for (Future<EnrichedOrder> f : futures) {
                result.add(f.get()); // waits safely
            }

            return result;
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Execution time in mils with virtual threads: " + duration/ 1_000_000);
        }
    }


}