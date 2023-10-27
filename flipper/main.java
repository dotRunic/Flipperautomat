package flipper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import zustände.NoCreditZustand;
import zustände.PlayingZustand;
import zustände.Person;
import zustände.ReadyZustand;
import zustände.Zustand;

public class main {
    public static void main(String[] args) {
        Person person = new Person();
        int remainingKickerUses = 3;
        boolean rampehit = false;
        boolean targethit = false;
        boolean bumperhit = false;
        int targetbonus = 20;
        int rampebonus = 50;
        int bumperbonus = 10;
        int kickCount = 1;
        int maxKick = 100;
        int lowKick = 10;
        Random random = new Random();

        List<FlipperElement> elements = new ArrayList<>(List.of());

        IncompatibleFlipperElement incompatibleElement = new IncompatibleFlipperElement();
        FlipperElementAdapter incompatibleElementAdapter = new FlipperElementAdapter(incompatibleElement);
        elements.add(incompatibleElementAdapter);

        IncompatibleCommand incompatibleCommand = new CustomIncompatibleCommand();
        IncompatibleCommandAdapter incompatibleCommandAdapter = new IncompatibleCommandAdapter(incompatibleCommand);

        FlipperElementVisitor punkteVisitor = new PunkteVisitor();

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Willst du das 'slant' oder 'spooky' Interface verwenden? 1: Slant, 2: Spooky");
            String interfaceChoice = input.nextLine().toLowerCase();

            String startScreenFileName;
            String gameOverFileName;
            String ball1FileName;
            String ball2FileName;
            String ball3FileName;
            String bonusRampeFilename;
            String bonusTargetFilename;
            String bonusBumperFilename;

            if (interfaceChoice.equals("1")) {
                startScreenFileName = "font/slant-start.txt";
                gameOverFileName = "font/slant-gameover.txt";
                ball1FileName = "font/slant-ball1.txt";
                ball2FileName = "font/slant-ball2.txt";
                ball3FileName = "font/slant-ball3.txt";
                bonusRampeFilename = "font/slant-bonus-rampe.txt";
                bonusTargetFilename = "font/slant-bonus-target.txt";
                bonusBumperFilename = "font/slant-bonus-bumper.txt";
            } else if (interfaceChoice.equals("2")) {
                startScreenFileName = "font/spooky-start.txt";
                gameOverFileName = "font/spooky-gameover.txt";
                ball1FileName = "font/spooky-ball1.txt";
                ball2FileName = "font/spooky-ball2.txt";
                ball3FileName = "font/spooky-ball3.txt";
                bonusRampeFilename = "font/spooky-bonus-rampe.txt";
                bonusTargetFilename = "font/spooky-bonus-target.txt";
                bonusBumperFilename = "font/spooky-bonus-bumper.txt";
            } else {
                System.out.println("Ungültige Auswahl. Standardmäßig wird das 'slant' Interface verwendet.");
                startScreenFileName = "font/slant-start.txt";
                gameOverFileName = "font/slant-gameover.txt";
                ball1FileName = "font/slant-ball1.txt";
                ball2FileName = "font/slant-ball2.txt";
                ball3FileName = "font/slant-ball3.txt";
                bonusRampeFilename = "font/slant-bonus-rampe.txt";
                bonusTargetFilename = "font/slant-bonus-target.txt";
                bonusBumperFilename = "font/slant-bonus-bumper.txt";
            }

            File startFile = new File("font/startscreen.txt");
            Scanner startScanner = new Scanner(startFile);
            while (startScanner.hasNextLine()) {
                System.out.println(startScanner.nextLine());
            }
            System.out.println("Willkommen zum Flipper-Spiel! (m für Münze werfen, q für Quit)");
            while (true) {
                System.out.print("Deine Wahl: ");
                String choice = input.nextLine();

                switch (choice.toLowerCase()) {
                    case "m":
                        File m = new File(startScreenFileName);
                        Scanner mScanner = new Scanner(m);
                        while (mScanner.hasNextLine()) {
                            System.out.println(mScanner.nextLine());
                        }
                        if (person.getZustand() instanceof NoCreditZustand) {
                            person.credit();
                            remainingKickerUses = 3;
                        } else if (person.getZustand() instanceof ReadyZustand) {
                            System.out.println("Du hast bereits Credit. Du kannst keine weitere Münze einwerfen.");
                        } else {
                            System.out.println("Du kannst keine Münze einwerfen, während du spielst.");
                        }
                        break;
                    case "q":
                        try {
                            File file = new File(gameOverFileName);
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }

                            fileScanner.close();
                            System.exit(0);
                        } catch (FileNotFoundException e) {
                            System.out.println("Datei nicht gefunden: " + e.getMessage());
                        }
                        break;
                    case "k":
                        if (person.getZustand() instanceof ReadyZustand) {
                            if (remainingKickerUses > 0) {
                                person.playing();

                                if (kickCount == 1) {
                                    File one = new File(ball1FileName);
                                    Scanner oneScanner = new Scanner(one);
                                    while (oneScanner.hasNextLine()) {
                                        System.out.println(oneScanner.nextLine());
                                    }
                                } else if (kickCount == 2) {
                                    File two = new File(ball2FileName);
                                    Scanner twoScanner = new Scanner(two);
                                    while (twoScanner.hasNextLine()) {
                                        System.out.println(twoScanner.nextLine());
                                    }
                                } else {
                                    File three = new File(ball3FileName);
                                    Scanner threeScanner = new Scanner(three);
                                    while (threeScanner.hasNextLine()) {
                                        System.out.println(threeScanner.nextLine());
                                    }
                                }
                                elements.forEach(element -> {
                                    if (element instanceof Kicker) {
                                        element.accept(new KickerActivateCommand(person));
                                    }
                                    // else if (element instanceof FlipperElementAdapter) {
                                    // element.accept(new IncompatibleCommandAdapter(incompatibleCommand));
                                    // }
                                });
                                int punkte = random.nextInt(maxKick - lowKick + 1) + lowKick;

                                if (Target.isTargetHit()) {
                                    targethit = true;
                                    punkte += targetbonus;
                                    File bonus = new File(bonusTargetFilename);
                                    Scanner bonusScanner = new Scanner(bonus);
                                    while (bonusScanner.hasNextLine()) {
                                        System.out.println(bonusScanner.nextLine());
                                    }
                                    System.out.println("BONUS HIT +20");
                                }

                                if (Rampe.isRampHit()) {
                                    rampehit = true;
                                    punkte += rampebonus;
                                    File bonus = new File(bonusRampeFilename);
                                    Scanner bonusScanner = new Scanner(bonus);
                                    while (bonusScanner.hasNextLine()) {
                                        System.out.println(bonusScanner.nextLine());
                                    }
                                    System.out.println("BONUS HIT +50");
                                }

                                if (Bumper.isBumperHit()) {
                                    bumperhit = true;
                                    punkte += bumperbonus;
                                    File bonus = new File(bonusBumperFilename);
                                    Scanner bonusScanner = new Scanner(bonus);
                                    while (bonusScanner.hasNextLine()) {
                                        System.out.println(bonusScanner.nextLine());
                                    }
                                    System.out.println("BONUS HIT +10");
                                }

                                System.out.println("Du hast " + punkte + " Punkte erhalten!");

                                person.addToScore(punkte);
                                System.out.println("Aktueller Punktestand: " + person.getScore());

                                // for(FlipperElement element : elements) {
                                // element.accept(punkteVisitor);
                                // }

                                // System.out.println("Punkte nach Kick " + kickCount + ": "+ ((PunkteVisitor)
                                // punkteVisitor).getPunkte());

                                kickCount++;
                                remainingKickerUses--;
                                if (kickCount > 3) {
                                    person.resetScore();
                                    kickCount = 1;
                                }
                            } else {
                                System.out
                                        .println("Du hast alle Kicker-Benutzungen aufgebraucht. Werfe eine Münze ein.");
                                person.resetNoCreditZustand();
                            }
                        } else {
                            System.out.println("Du kannst den Kicker nicht benutzen.");
                        }
                        break;
                    case "i":
                        incompatibleCommandAdapter.execute();
                        break;
                    default:
                        System.out.println("Ungültige Eingabe. Versuche es erneut.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ein Fehler ist aufgetreten: " + e.getMessage());
        }
    }

}