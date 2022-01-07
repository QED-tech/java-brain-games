package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;

public class Engine {
    public static void run(String gameNumber) {
        final int numberOfLaps = 3;

        switch (gameNumber) {
            case "1" -> Cli.greeting();
            case "2" -> Even.run(Cli.greeting(), numberOfLaps);
            case "3" -> Calculator.run(Cli.greeting(), numberOfLaps);
            default -> {
                return;
            }
        }
    }
}
