package flipper;

import java.util.Arrays;
import java.util.List;

// Concrete Mediator
public class FlipperMediatorImpl implements FlipperMediator {
    private List<FlipperElement> targets;
    private Rampe rampe;

    public FlipperMediatorImpl(List<FlipperElement> elements, Rampe rampe) {
        this.targets = elements;
        this.rampe = rampe;
    }

    @Override
    public void notifyTargetHit(Target target) {
        targets.remove(target);
        if (targets.isEmpty()) {
            notifyRampOpen();
        }
    }

    @Override
    public void notifyRampOpen() {
        rampe.open();
    }

    @Override
    public void notifyTargetsReset() {
        targets.clear(); // Entferne alle vorhandenen Targets
        for (int i = 0; i < 3; i++) {
            targets.add(new Target()); // Füge drei neue Targets hinzu
        }
    }
    

}
