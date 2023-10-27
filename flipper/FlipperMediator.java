package flipper;

import java.util.List;

// Mediator Interface
public interface FlipperMediator {
    void notifyTargetHit(Target target);
    void notifyRampOpen();
    void notifyTargetsReset();
}



