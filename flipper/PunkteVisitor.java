package flipper;

public class PunkteVisitor implements FlipperElementVisitor {
    private int punkte;

    public int getPunkte() {
        return punkte;
    }

    // @Override
    public void visit(Target target) {
        // Berechne Punkte für das Target, hier als Beispiel: Anzahl der Durchläufe * Level
        punkte += target.getAnzahlDurchlaeufe() * 100; //  * LevelManager.getLevel()
    }

    // @Override
    public void visit(Rampe rampe) {
        // Implementiere Logik für die Punkteberechnung der Rampe
        // ...
        punkte += 50;
    }

    @Override
    public void visit(Bumper bumper) {
        punkte += 20;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(Kicker kicker) {
        punkte += 30;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
