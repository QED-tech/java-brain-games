package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

public class Engine {
    public static void run(String gameNumber) {
        final int numberOfLaps = 3;

        switch (gameNumber) {
            case "1" -> Cli.greeting();
            case "2" -> Even.run(Cli.greeting(), numberOfLaps);
            case "3" -> Calculator.run(Cli.greeting(), numberOfLaps);
            case "4" -> Gcd.run(Cli.greeting(), numberOfLaps);
            case "5" -> Progression.run(Cli.greeting(), numberOfLaps);
            default -> {
                return;
            }
        }
    }
}
