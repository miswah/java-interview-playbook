Transaction Engine (Command Pattern)
The Scenario

You are building the transaction execution engine for a lightweight, in-memory Key-Value database. The database must support executing operations and rolling them back (undoing) in the exact reverse order they were applied.
The Scaffolding (Your Starting Code)

Here are the foundational classes and interfaces you must use.

1. The Data Model:
```Java

public record DatabaseRow(String id, String payload) {}
```
2. The Receiver (The actual database):
```Java

import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    private final Map<String, DatabaseRow> store = new HashMap<>();

    public void insertOrUpdate(String key, DatabaseRow row) {
        store.put(key, row);
    }

    public void delete(String key) {
        store.remove(key);
    }

    public DatabaseRow get(String key) {
        return store.get(key);
    }
    
    public void printStore() {
        System.out.println("Current DB State: " + store);
    }
}
``

3. The Command Interface:
``Java

public interface TransactionCommand {
    void execute();
    void undo();
}
``
Your Mission

You must implement the following components:

1. Concrete Commands: * Create a PutCommand that implements TransactionCommand. It should handle inserting a new row or updating an existing one.

    Create a DeleteCommand that implements TransactionCommand. It should handle deleting a row.

2. The Invoker (TransactionEngine):

    Create a TransactionEngine class.

    It must have an executeCommand(TransactionCommand command) method.

    It must have an undoLastTransaction() method.

LLD Constraints (The Brutal Criteria)

    Perfect State Reversal (The Trap): Your undo() logic must be flawless.

        If PutCommand updates an existing key, undoing it must restore the previous value, not just delete it.

        If PutCommand inserts a brand new key, undoing it must delete that key.

        If DeleteCommand removes a key, undoing it must restore the exact DatabaseRow that was deleted.

    History Management: The TransactionEngine must use a Stack (or Deque) to keep track of the executed commands so it can undo them in a Last-In-First-Out (LIFO) order.

    Edge Cases: Your engine should not crash if undoLastTransaction() is called when there is no history.
