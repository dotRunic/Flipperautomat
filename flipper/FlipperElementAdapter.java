package flipper;

public class FlipperElementAdapter extends FlipperElement {
    private IncompatibleFlipperElement incompatibleElement;

    public FlipperElementAdapter(IncompatibleFlipperElement element) {
        this.incompatibleElement = element;
    }

    @Override
    public void accept(Command command) {
        if (command instanceof IncompatibleCommandAdapter) {
            ((IncompatibleCommandAdapter) command).execute();
        } else {
            // Handle other compatible commands if needed
            System.out.println("Inkompatibler Befehl für dieses Element.");
        }
    }

    @Override
    public void accept(FlipperElementVisitor visitor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

    // @Override
    // public void visitaccept(FlipperElementVisitor visitor) {
    //     if (visitor instanceof IncompatibleCommandAdapter) {
    //         ((IncompatibleCommandAdapter) visitor).execute();
    //     } else {
    //         // Handle other compatible commands if needed
    //         System.out.println("Inkompatibler Befehl für dieses Element.");
    //     }
    // }
}
