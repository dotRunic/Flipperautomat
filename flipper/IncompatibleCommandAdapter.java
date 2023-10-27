package flipper;

public class IncompatibleCommandAdapter implements Command {
    private IncompatibleCommand incompatibleCommand;

    public IncompatibleCommandAdapter(IncompatibleCommand command) {
        this.incompatibleCommand = command;
    }

    @Override
    public void execute() {
        incompatibleCommand.execute();
    }
}