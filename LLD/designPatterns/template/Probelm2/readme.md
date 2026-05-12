# Order Fulfillment Engine (Template Pattern)

## The Scenario

You are designing the core order processing pipeline for an e-commerce platform. The platform sells two types of products: **Physical Goods** (like laptops) and **Digital Goods** (like software licenses).

Regardless of what the customer buys, the high-level steps to fulfill an order are strictly defined:

1. **Validate Order:** Check if the order data is valid (Shared common logic).
2. **Process Payment:** Charge the customer's credit card (Shared common logic).
3. **Calculate Additional Fees:** Calculate shipping or handling fees. (Digital goods have $0 fees, but physical goods require a calculation).
4. **Prepare Delivery:** Actually get the product ready. (For physical goods: print shipping labels and pack boxes. For digital goods: generate a secure download link).
5. **Send Confirmation:** Send an email to the customer. (Can be customized by the specific order type, but has a standard default).

## The Scaffolding (Your Starting Code)

**1. The Data Model:**

```java
public enum OrderType { PHYSICAL, DIGITAL }

public record Order(String orderId, double basePrice, String customerEmail, OrderType type) {}

```

**2. The External Services (Provided - Assume these are injected):**

```java
public class PaymentGateway {
    public void charge(double amount) {
        System.out.println("Charged: $" + amount);
    }
}

public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Email sent to " + to + ": " + message);
    }
}

```

## Your Mission

**1. The Abstract Template (`OrderProcessor`):**

* Create the `OrderProcessor` abstract class.
* Implement the template method `fulfillOrder(Order order)`. It must calculate the *final total* (base price + additional fees) and pass that to the payment gateway.
* Implement the shared logic for Validation (just print "Validating order...") and Payment.
* Define the exact hooks and abstract steps needed for Fees, Preparation, and Confirmation.

**2. The Concrete Processors:**

* Create a `PhysicalOrderProcessor`.
* *Implementation detail:* Fees are a flat `$15.00`. Preparation prints `"Packing boxes and printing shipping label."`


* Create a `DigitalOrderProcessor`.
* *Implementation detail:* Fees are `$0.00`. Preparation prints `"Generating secure download link."`
* Override the confirmation hook to add a special message: `"Email sent: Here is your download link and activation key!"`



## Constraints

* **The Iron Skeleton:** The `fulfillOrder` method must be unbreakable. No one should be able to override it.
* **Flawless Encapsulation:** Apply what you learned in the last review. Hide the internal algorithm steps from the outside world. Only the subclasses should interact with the steps they are responsible for.
* **State Management:** Notice that the `calculateAdditionalFees` step returns a value that needs to be used by the `processPayment` step. Handle this cleanly within the template method.
* **Correct Hook Usage:** Differentiate between an *Abstract Step* (which subclasses MUST implement) and a *Hook* (which has a default behavior but CAN be overridden).

---

### Challenge

Write the `OrderProcessor`, `PhysicalOrderProcessor`, and `DigitalOrderProcessor` classes. Pay obsessive attention to your access modifiers. Send the code when you are ready for the brutal review!