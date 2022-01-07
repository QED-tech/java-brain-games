package hexlet.code;

import hexlet.code.games.*;

public class Engine {
    public static void run(String gameNumber) {
        final int numberOfLaps = 3;

        switch (gameNumber) {
            case "1" -> Cli.greeting();
            case "2" -> Even.run(Cli.greeting(), numberOfLaps);
            case "3" -> Calculator.run(Cli.greeting(), numberOfLaps);
            case "4" -> Gcd.run(Cli.greeting(), numberOfLaps);
            case "5" -> Progression.run(Cli.greeting(), numberOfLaps);
            case "6" -> Prime.run(Cli.greeting(), numberOfLaps);
            default -> {
                return;
            }
        }
    }
}
