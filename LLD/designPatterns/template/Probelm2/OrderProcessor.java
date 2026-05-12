public abstract class OrderProcessor {

    private final EmailService emailService = new EmailService();
    private final PaymentGateway paymentGateway = new PaymentGateway();

    public final void fulfillOrder(Order order){
        if(!validateOrder()){
            System.out.println("Not a valid order");
            return;
        }

        double additionalFees = calculateAdditionFees();

        processPayment(order.basePrice() + additionalFees);

        prepareDelivery();

        sendConfirmationEmail(order.customerEmail());
    }

    private final boolean validateOrder(){
        return true;
    }

    private final void processPayment(double amount){
        this.paymentGateway.charge(amount);
    }

    protected abstract double calculateAdditionFees();
    protected abstract void prepareDelivery();

    protected void sendConfirmationEmail(String to){
        this.emailService.sendEmail(to, getConfirmationMessage());
    }

    protected String getConfirmationMessage(){
        return "Order processed";
    }
}
