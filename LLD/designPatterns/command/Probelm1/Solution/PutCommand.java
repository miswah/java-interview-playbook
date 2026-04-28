public class PutCommand implements TransactionCommand{
    private final KeyValueStore db;
    private final String key;
    private final DatabaseRow value;

    private DatabaseRow lastValue;

    public PutCommand(KeyValueStore db, String key, DatabaseRow value){
        this.db = db;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        this.lastValue = this.db.get(this.key);
        this.db.insertOrUpdate(this.key, this.value);
    }

    @Override
    public void undo() {

            if(this.lastValue == null){
                this.db.delete(this.key);
            } else {
                this.db.insertOrUpdate(this.key, this.lastValue);
            }

    }
}
