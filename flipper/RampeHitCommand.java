package flipper;

import zustände.Person;

public class RampeHitCommand implements Command {
    private Bumper bumper;

    public RampeHitCommand(Bumper person) {
        this.bumper = person;
    }
    public RampeHitCommand(Person person) {
    }
    
    @Override
    public void execute() {
        bumper.hit();
    }
}