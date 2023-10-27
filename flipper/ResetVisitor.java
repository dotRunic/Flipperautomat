package flipper;

public class ResetVisitor implements FlipperElementVisitor {
    // @Override
    public void visit(Target target) {
        // Setze das Target in den Anfangszustand zurück
        target.reset();
    }

    // @Override
    public void visit(Rampe rampe) {
        // Schließe die Rampe
        rampe.close();
    }
    // Implementiere weitere visit-Methoden für andere Flipper-Elemente

    @Override
    public void visit(Bumper bumper) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Kicker kicker) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
