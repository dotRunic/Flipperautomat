package zustände;

import java.util.Scanner;

public class Person {
    private Zustand zustand = new NoCreditZustand(this);
    private int score = 0;

   public int getScore() {
    return this.score;
   }

   public void addToScore(int points) {
    this.score += points;
   }

   public void resetScore() {
    this.score = 0;
   }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }

    public Zustand getZustand() {
        return this.zustand;
    }

    public void credit() {
        zustand.credit();
    }

    public void playing() {
        zustand.playing();
    }

    public void ready() {
        zustand.ready();
    }

    public void userAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Was möchtest du tun? (k für Kicker, b für Bumper, r für Rampe, q für Quit)");
        String choice = scanner.nextLine();

        switch (choice.toLowerCase()) {
            case "k":
                setZustand(new ReadyZustand(this));
                break;
            case "b":
                setZustand(new PlayingZustand(this));
                break;
            case "r":
                setZustand(new PlayingZustand(this));
                break;
            case "q":
                System.out.println("Spiel beendet.");
                System.exit(0);
            default:
                System.out.println("Ungültige Eingabe. Versuche es erneut.");
                break;
        }
    }

     public void resetNoCreditZustand() {
        setZustand(new NoCreditZustand(this));
    }

}
