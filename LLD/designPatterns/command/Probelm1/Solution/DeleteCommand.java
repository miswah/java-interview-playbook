public class DeleteCommand implements TransactionCommand{
    private final KeyValueStore db;
    private final String key;
    private DatabaseRow value;

    public DeleteCommand(KeyValueStore db, String key) {
        this.db = db;
        this.key = key;
    }

    @Override
    public void execute() {
        this.value = this.db.get(this.key);
        this.db.delete(this.key);
    }

    @Override
    public void undo() {
        this.db.insertOrUpdate(this.key, this.value);
    }
}
