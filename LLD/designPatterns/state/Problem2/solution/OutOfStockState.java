package org.miswah;

public class OutOfStockState implements State {

    private VendingMachine vendingMachine;

    public OutOfStockState(VendingMachine machine){
        this.vendingMachine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("out of stock");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Can't eject coin");
    }

    @Override
    public void selectProduct() {
        System.out.println("no product found");
    }

    @Override
    public void dispense() {
        System.out.println("out of stock");
    }
}
