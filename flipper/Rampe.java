package flipper;

import java.util.Random;

public class Rampe extends FlipperElement {

    private FlipperMediator mediator;
    private boolean isOpen;

    public static boolean isRampHit() {
        Random random = new Random();
        int chance = random.nextInt(100); // Eine Zufallszahl zwischen 0 und 99
        return chance < 20; // Zum Beispiel: Die Rampe hat eine 30%ige Chance, getroffen zu werden
    }

    public Rampe(FlipperMediator mediator) {
        this.mediator = mediator;
        this.isOpen = false;
    }

    public void open() {
        isOpen = true;
        mediator.notifyRampOpen();
        // Logik für das Öffnen der Rampe
    }
    
    public void close() {
        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void reset() {
        isOpen = false;
        mediator.notifyTargetsReset();
    }

    @Override
    public void accept(Command command) {
        command.execute();
    }

    public void hit() {
        // Logik für den Bumper-Hit
        // if (trifftRampe()) {
        //     System.out.println("Du hast die Rampe getroffen! +50 Punkte!");
        // }
    }
    
    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    // @Override
    public void visit(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }
}
