# ETL Data Processor (Template Pattern)

## The Scenario

You are building an end-of-day data ingestion pipeline for a financial system. Every night, the system receives transaction files from different payment gateways.

Stripe sends files in **JSON** format, while an older legacy bank sends files in **CSV** format.

The core ingestion algorithm is always the same:

1. Read the raw data from the file path.
2. Parse the raw data into standard `Transaction` objects.
3. Filter out any transactions with a negative amount (fraud prevention).
4. Save the valid transactions to the database.
5. (Optional) Run a custom cleanup or audit step after processing.

## The Scaffolding

**1. The Data Model:**

```java
public record Transaction(String id, double amount, String currency) {}

```

**2. The Database (Provided):**

```java
import java.util.List;

public class TransactionDatabase {
    public void saveAll(List<Transaction> transactions) {
        System.out.println("Saving " + transactions.size() + " transactions to DB...");
        transactions.forEach(tx -> System.out.println(" -> Inserted: " + tx));
    }
}

```

## Your Mission

**1. The Abstract Template (`DataProcessor`):**
Create an abstract class `DataProcessor` that defines the core algorithm.

* It must have a method `processFile(String filePath)` representing the template method.
* It must define the required abstract steps for reading and parsing data.
* It must implement the common logic for filtering negative amounts and saving to the database.
* It must provide an optional "Hook" method for post-processing.

**2. The Concrete Processors:**

* Create a `CsvDataProcessor` extending `DataProcessor`.
* *Mock implementation details:* For reading, just return `"CSV_RAW_DATA"`. For parsing, return a hardcoded list of transactions: `[("TX1", 100.0, "USD"), ("TX2", -50.0, "EUR")]`.


* Create a `JsonDataProcessor` extending `DataProcessor`.
* *Mock implementation details:* For reading, just return `"{JSON_RAW_DATA}"`. For parsing, return: `[("TX3", 200.0, "GBP")]`.
* Override the optional hook method to print `"Audit log: JSON processing complete."`



## Constraints

* **The Iron Skeleton:** The overarching algorithm (`processFile`) **MUST NOT** be overridable by any subclass. If a junior dev tries to override it and change the order of operations, the compiler should stop them.
* **Visibility Control:** Abstract steps (`readData`, `parseData`) and common steps should only be accessible to the pipeline itself or its subclasses. They should *never* be called directly from outside the class (e.g., a user should only be able to call `processor.processFile()`, not `processor.parseData()`).
* **Hook Mechanism:** Properly implement the hook method so that the base class provides a default (empty) implementation, allowing subclasses to ignore it or override it as needed.

---

### Challange

Write the code for `DataProcessor`, `CsvDataProcessor`, and `JsonDataProcessor`. Pay very close attention to your **access modifiers** (`public`, `protected`, `private`, `final`). Send it over, and I'll brutally review your architectural boundaries!