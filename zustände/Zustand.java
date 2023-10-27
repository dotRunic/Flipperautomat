package zustände;

public abstract class Zustand {

    public final Person person;

    public Zustand(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }
    
    public abstract void credit();
    
    public abstract void playing();

    public abstract void ready();

}