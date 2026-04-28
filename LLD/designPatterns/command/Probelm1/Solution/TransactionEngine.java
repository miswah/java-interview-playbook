import java.util.Stack;

public class TransactionEngine {

    private final Stack<TransactionCommand> commandsHistory = new Stack<>();

    public void executeCommand(TransactionCommand command){
        this.commandsHistory.push(command);
        command.execute();
    }

    public void undoLastTransaction() {
        if(!this.commandsHistory.isEmpty()){
            TransactionCommand lastOp = this.commandsHistory.pop();
            lastOp.undo();
        } else {
            System.out.println("No operations to undo");
        }
    }
}
