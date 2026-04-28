import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        KeyValueStore db = new KeyValueStore();

        PutCommand putOp = new PutCommand(db, "test1", new DatabaseRow("1", "test payload1"));

        putOp.execute();

        db.printStore();

        putOp.undo();

        db.printStore();
    }
}