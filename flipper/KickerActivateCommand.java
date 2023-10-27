package flipper;

import zustände.Person;

public class KickerActivateCommand implements Command {
    private Person person;

    public KickerActivateCommand(Person person) {
        this.person = person;
    }

    @Override
    public void execute() {
        System.out.println("der kicker wurde aktiviert!");
        person.playing(); // Ändere den Zustand der Person, um zu signalisieren, dass sie spielt.
    }

// @Override
    public void accept() {
        System.out.println("der kicker wurde acceptiert!");
        person.ready(); // Ändere den Zustand der Person, um zu signalisieren, dass sie spielt.
    }


}


// Ähnlich kannst du für Rampe und Target Klassen erstellen.
