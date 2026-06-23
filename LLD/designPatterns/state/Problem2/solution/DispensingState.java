package org.miswah;

public class DispensingState implements State {

    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already present");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Can't eject coin");
    }

    @Override
    public void selectProduct() {
        System.out.println("Enter coin first");
    }

    @Override
    public void dispense() {
        if(this.vendingMachine.getInventory() > 0){
            this.vendingMachine.releaseProduct();
            if(this.vendingMachine.getInventory() > 0){
                this.vendingMachine.setState(this.vendingMachine.getNoCoinState());
            } else {
                this.vendingMachine.setState(this.vendingMachine.getOutOfStockState());
            }

        } else {
            System.out.println("Out of Stock");
            this.vendingMachine.setState(this.vendingMachine.getOutOfStockState());
        }
    }
}
