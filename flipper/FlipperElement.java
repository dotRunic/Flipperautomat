package flipper;

public abstract class FlipperElement {
    public abstract void accept(Command command);

    public abstract void accept(FlipperElementVisitor visitor); 
}
