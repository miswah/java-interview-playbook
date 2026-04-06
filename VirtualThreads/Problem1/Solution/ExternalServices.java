public class ExternalServices {

    public static User fetchUser(int userId) {
        sleep(200); // simulate API delay
        return new User(userId, "User-" + userId);
    }

    public static Payment fetchPayment(int orderId) {
        sleep(300); // simulate API delay
        return new Payment(orderId, "SUCCESS");
    }

    private static void sleep(long millis) {
        try { Thread.sleep(millis); }
        catch (InterruptedException e) { throw new RuntimeException(e); }
    }
}