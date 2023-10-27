package flipper;

import java.util.Random;

public class Bumper extends FlipperElement {

    @Override
    public void accept(Command command) {
        command.execute();
    }

    public void hit() {
        // Logik für den Bumper-Hit
    }
    
    // @Override
    public void visit(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    public static boolean isBumperHit() {
        Random random = new Random();
        int chance = random.nextInt(100); 
        return chance < 10; 
    }


}
