package org.miswah;

public class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void insertCoin() {
        this.vendingMachine.setState(this.vendingMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("Can't eject coin");
    }

    @Override
    public void selectProduct() {
        System.out.println("enter coin first");
    }

    @Override
    public void dispense() {
        System.out.println("enter coin first");
    }
}
