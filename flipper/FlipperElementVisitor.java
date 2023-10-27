package flipper;
public interface FlipperElementVisitor {

    void visit(Rampe rampe);
    void visit(Target target);
    void visit(Bumper bumper);
    void visit(Kicker kicker);



    // public void visit(Rampe rampe) {
    //     // System.out.println("Rampe getroffen!");
    // }

    // public void visit(Target target) {
    //     // System.out.println("Target getroffen!");
    // }

    // public void visit(Bumper bumper) {
    //     // System.out.println("Bumper getroffen!");
    // }

    // public void visit(Kicker kicker) {
    //     // System.out.println("Kicker getroffen!");
    // }

}
