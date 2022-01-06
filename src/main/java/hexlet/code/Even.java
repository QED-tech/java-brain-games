package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void run() {
        var name = Cli.greeting();
        Even.printRules();

        final int numberOfLaps = 3;
        final int maximumNumber = 20;

        for (var i = 0; i < numberOfLaps; i++) {
            var number = (int) (Math.random() * maximumNumber);
            System.out.printf("Question: %d%n", number);

            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();

            boolean answerIsCorrect = Even.isEven(number) == answerToBoolean(answer)
                    && (answer.equals("yes") || answer.equals("no"));

            if (!answerIsCorrect) {
                Even.printWrongAnswer(answer, name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", name);
    }

    private static void printWrongAnswer(String answer, String name) {
        if (answer.equals("yes")) {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was 'no'.%n", answer);
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was 'yes'.%n", answer);
        }

        System.out.printf("Let's try again, %s!%n", name);
    }

    private static void printRules() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean answerToBoolean(String answer) {
        return answer.equals("yes");
    }
}
