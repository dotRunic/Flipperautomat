package zustände;
public class PlayingZustand extends Zustand {

    public PlayingZustand(Person person) {
        super(person);
    }

    
    @Override
    public void credit(){
        System.out.println("ich besitzte noch credit");
    }
    
    @Override
    public void ready() {
        System.out.println("bin bereits ready, und der author dieser software ist michael beyer und anas mohammad!");
    }

    @Override
    public void playing(){
        System.out.println("ich spiele flipper!");
        getPerson().setZustand(new NoCreditZustand(getPerson()));
    }
    
}
