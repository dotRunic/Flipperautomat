package flipper;

public class Kicker extends FlipperElement {

    @Override
    public void accept(Command command) {
        command.execute();
    }

    public void activate() {
        // Logik für den Kicker aktivieren
    }

    // @Override
    public void visit(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        visitor.visit(this);
    }

}
