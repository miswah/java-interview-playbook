# Smart Vending Machine

You are building the software for a new vending machine. The machine behaves differently depending on its current state. If a user tries to do something out of order (like selecting a product before inserting a coin), the machine needs to handle it gracefully without crashing or dispensing free items.


You need to implement the State pattern to manage the following four states:

    NoCoinState: The machine is waiting for a user to insert a coin.

    HasCoinState: A coin has been inserted, and the machine is waiting for the user to select a product.

    DispensingState: The user has selected a product, and the machine is currently dispensing it.

    OutOfStockState: The machine has no inventory left.

The machine has four actions that can trigger state transitions:

    insertCoin():

        If in NoCoinState, accept the coin and transition to HasCoinState.

        If in other states, reject the coin or print an error message.

    ejectCoin():

        If in HasCoinState, return the coin and transition to NoCoinState.

        If in other states, print an error message.

    selectProduct():

        If in HasCoinState, transition to DispensingState, then immediately call the dispense action.

        If in other states, print an error message.

    dispense():

        This is an internal action. If in DispensingState, reduce the inventory by 1. If inventory drops to 0, transition to OutOfStockState. Otherwise, transition back to NoCoinState.

        If triggered in any other state, it should fail or do nothing.



```java
// 1. The State Interface
public interface State {
    void insertCoin();
    void ejectCoin();
    void selectProduct();
    void dispense();
}

// 2. The Context Class
public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State dispensingState;
    private State outOfStockState;

    private State currentState;
    private int inventory = 0;

    public VendingMachine(int inventory) {
        // TODO: Initialize all the state objects (e.g., this.noCoinState = new NoCoinState(this);)
        this.inventory = inventory;
        
        // TODO: Set the initial state. If inventory > 0, set to noCoinState. Otherwise, outOfStockState.
    }

    // --- Actions delegated to the current state ---
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

    // Getters for the states so the concrete states can transition
    public State getNoCoinState() { return noCoinState; }
    public State getHasCoinState() { return hasCoinState; }
    public State getDispensingState() { return dispensingState; }
    public State getOutOfStockState() { return outOfStockState; }
}

// 3. Concrete States (Implement the logic for each!)

class NoCoinState implements State {
    private VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        // TODO: Implement logic
    }

    @Override
    public void ejectCoin() {
        // TODO: Implement logic
    }

    @Override
    public void selectProduct() {
        // TODO: Implement logic
    }

    @Override
    public void dispense() {
        // TODO: Implement logic
    }
}

class HasCoinState implements State {
    private VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // TODO: Implement all 4 methods for this state
    @Override public void insertCoin() { /* ... */ }
    @Override public void ejectCoin() { /* ... */ }
    @Override public void selectProduct() { /* ... */ }
    @Override public void dispense() { /* ... */ }
}

class DispensingState implements State {
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // TODO: Implement all 4 methods for this state
    @Override public void insertCoin() { /* ... */ }
    @Override public void ejectCoin() { /* ... */ }
    @Override public void selectProduct() { /* ... */ }
    @Override public void dispense() { /* ... */ }
}

class OutOfStockState implements State {
    private VendingMachine vendingMachine;

    public OutOfStockState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    // TODO: Implement all 4 methods for this state
    @Override public void insertCoin() { /* ... */ }
    @Override public void ejectCoin() { /* ... */ }
    @Override public void selectProduct() { /* ... */ }
    @Override public void dispense() { /* ... */ }
}

// 4. Main Class for Testing
public class Main {
    public static void main(String[] args) {
        // Test your implementation here!
        VendingMachine machine = new VendingMachine(2);

        System.out.println("--- Test 1: Successful purchase ---");
        machine.insertCoin();
        machine.selectProduct();

        System.out.println("\n--- Test 2: Try to eject without a coin ---");
        machine.ejectCoin();

        System.out.println("\n--- Test 3: Buy last item and check out of stock ---");
        machine.insertCoin();
        machine.selectProduct();
        machine.insertCoin(); // Should be rejected, out of stock!
    }
}
```
