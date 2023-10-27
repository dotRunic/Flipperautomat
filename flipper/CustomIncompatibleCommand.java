package flipper;

public class CustomIncompatibleCommand implements IncompatibleCommand {
    @Override
    public void execute() {
        System.out.println("Inkompatible Aktion ausgeführt!");
    }
}
