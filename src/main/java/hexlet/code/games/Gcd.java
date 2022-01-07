package hexlet.code.games;

import java.util.Scanner;

public class Gcd {

    public static void run(String name, int numberOfLaps) {
        Gcd.printRules();

        for (var i = 0; i < numberOfLaps; i++) {
            var question = Gcd.getQuestion();
            System.out.printf("Question: %s%n", question);

            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();

            int correctAnswer = Gcd.gcd(question);
            boolean answerIsCorrect = Integer.parseInt(answer) == correctAnswer;

            if (!answerIsCorrect) {
                Gcd.printWrongAnswer(answer, Integer.toString(correctAnswer), name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", name);
    }

    private static int gcd(String question) {
        String[] numbers = question.split(" ");
        var a = Integer.parseInt(numbers[0]);
        var b = Integer.parseInt(numbers[1]);

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }

    private static String getQuestion() {
        final int maximumNumber = 40;
        var leftOperand = (int) (Math.random() * maximumNumber);
        var rightOperand = (int) (Math.random() * maximumNumber);

        return String.format("%d %d", leftOperand, rightOperand);
    }

    private static void printWrongAnswer(String answer, String correctAnswer, String name) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
        System.out.printf("Let's try again, %s!%n", name);
    }

    private static void printRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }
}
