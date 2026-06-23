package org.miswah;

public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State dispensingState;
    private State outOfStockState;

    private State currentState;
    private int inventory = 0;

    public VendingMachine(int inventory) {
       this.noCoinState = new NoCoinState(this);
       this.hasCoinState = new HasCoinState(this);
       this.dispensingState = new DispensingState(this);
       this.outOfStockState = new OutOfStockState(this);


        this.inventory = inventory;

        if(this.getInventory() > 0){
            this.setState(this.noCoinState);
        } else {
            this.setState(this.outOfStockState);
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
        // Note: dispense() is usually called automatically by selectProduct() in the State class!
    }

    // --- Helper methods for State classes to use ---
    public void releaseProduct() {
        System.out.println("A product comes rolling out the slot...");
        if (inventory > 0) {
            inventory--;
        }
    }

    public int getInventory() {
        return inventory;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    // Getters for the states so the concrete states can transition
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getDispensingState() { return dispensingState; }
    public State getOutOfStockState() { return outOfStockState; }
}
