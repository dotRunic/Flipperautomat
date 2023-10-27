package flipper;

import zustände.Person;

public class BumperHitCommand implements Command {
    private Bumper bumper;

    public BumperHitCommand(Bumper person) {
        this.bumper = person;
    }
    public BumperHitCommand(Person person) {
    }
    @Override
    public void execute() {
        bumper.hit();
    }
}