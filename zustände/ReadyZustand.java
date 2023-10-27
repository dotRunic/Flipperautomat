package zustände;
public class ReadyZustand extends Zustand {

    public ReadyZustand(Person person) {
        super(person);
    }

    
    
    @Override
    public void credit(){
        System.out.println("ich besitze noch genügend credit");
    }
    
    @Override
    public void ready() {
        System.out.println("ich drücke den ready knopf");
        getPerson().setZustand(new PlayingZustand(getPerson()));
    }
    
    @Override
    public void playing(){
        System.out.println("ich bin bereit zum spielen");
    }
}
