package org.miswah;

public class HasCoinState implements State {

    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already present");
    }

    @Override
    public void ejectCoin() {
        this.vendingMachine.setState(this.vendingMachine.getNoCoinState());
    }

    @Override
    public void selectProduct() {
        State dispensingState = this.vendingMachine.getDispensingState();
        this.vendingMachine.setState(dispensingState);
        dispensingState.dispense();
    }

    @Override
    public void dispense() {
        System.out.println("Selected a product");
    }
}
