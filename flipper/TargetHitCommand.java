package flipper;

import zustände.Person;

public class TargetHitCommand implements Command {
    private Bumper bumper;

    public TargetHitCommand(Bumper person) {
        this.bumper = person;
    }
    public TargetHitCommand(Person person) {
    }
    
    @Override
    public void execute() {
        bumper.hit();
    }
}