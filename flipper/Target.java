package flipper;

import java.util.Random;

public class Target extends FlipperElement {

    private FlipperMediator mediator;
    private int anzahlDurchlaeufe;

    public Target(FlipperMediator mediator) {
        this.mediator = mediator;
        this.anzahlDurchlaeufe = 0;
    }

    public Target() {
        this.mediator = null;
        this.anzahlDurchlaeufe = 0;
    }

    public void hit() {
        // Logik für den Target-Hit
        anzahlDurchlaeufe++;
        if (mediator != null) {
            mediator.notifyTargetHit(this);
        } else {
            System.out.println("Kein Mediator vorhanden für das Target-Hit");
        }
    }

    @Override
    public void accept(Command command) {
        command.execute();
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    // @Override
    public void visit(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    public void reset() {
        // Setze das Target in den Anfangszustand zurück
        anzahlDurchlaeufe = 0;
    }

    public int getAnzahlDurchlaeufe() {
        return anzahlDurchlaeufe;
    }
    // @Override
    // public void visitaccept(FlipperElementVisitor visitor) {
    //     visitor.visit(this);
    // }
    // public void hit() {
    // // Logik für den Bumper-Hit
    // }
    public static boolean isTargetHit() {
        Random random = new Random();
        int chance = random.nextInt(100); // Eine Zufallszahl zwischen 0 und 99
        return chance < 30; 
    }


}
