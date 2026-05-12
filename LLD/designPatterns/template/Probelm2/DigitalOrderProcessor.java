public class DigitalOrderProcessor extends OrderProcessor{
    @Override
    protected double calculateAdditionFees() {
        return 0;
    }

    @Override
    protected void prepareDelivery() {
        System.out.println("Generating secure download link.");
    }

    @Override
    protected String getConfirmationMessage(){
        return "Email sent: Here is your download link and activation key!";
    }
}
