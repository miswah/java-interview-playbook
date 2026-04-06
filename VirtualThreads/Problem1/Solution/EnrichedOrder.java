public record EnrichedOrder(
        int orderId,
        String userName,
        double amount,
        String paymentStatus
) {}