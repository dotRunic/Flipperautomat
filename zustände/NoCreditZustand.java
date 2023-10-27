package zustände;
public class NoCreditZustand extends Zustand {

    public NoCreditZustand(Person person) {
        super(person);
    }

    @Override
    public void credit(){
        System.out.println("ich werfe eine münze ein");
        getPerson().setZustand(new ReadyZustand(getPerson()));
    }
    
    @Override
    public void ready() {
        System.out.println("ich besitzte keinen credit");
    }
    
    @Override
    public void playing(){
        System.out.println("ich kann nicht spielen, da ich nicht ready bin");
    }
    
}
