package org.miswah;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        machine.insertCoin();
    }
}

