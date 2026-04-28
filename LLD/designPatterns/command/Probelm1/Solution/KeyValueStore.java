import java.util.HashMap;
import java.util.Map;

public class KeyValueStore {
    private static final Map<String, DatabaseRow> store = new HashMap<>();

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