public class PhysicalOrderProcessor extends OrderProcessor{
    @Override
    protected double calculateAdditionFees() {
        return 15.00;
    }

    @Override
    protected void prepareDelivery() {
        System.out.println("Packing boxes and printing shipping label.");
    }
}
