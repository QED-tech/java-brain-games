package hexlet.code.games;

import java.util.Scanner;

public class Prime {

    public static void run(String name, int numberOfLaps) {
        Prime.printRules();

        for (var i = 0; i < numberOfLaps; i++) {
            var question = Prime.getQuestion();
            System.out.printf("Question: %s%n", question);

            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();

            boolean answerIsCorrect = Prime.isPrime(Integer.parseInt(question)) == answerToBoolean(answer)
                    && (answer.equals("yes") || answer.equals("no"));

            if (!answerIsCorrect) {
                Prime.printWrongAnswer(answer, answer.equals("no") ? "yes" : "no", name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", name);
    }

    private static String getQuestion() {
        final int maximumNumber = 20;
        return Integer.toString((int) (Math.random() * maximumNumber));
    }

    private static void printWrongAnswer(String answer, String correctAnswer, String name) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
        System.out.printf("Let's try again, %s!%n", name);
    }

    private static void printRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    private static boolean isPrime(int number) {
        for (var i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean answerToBoolean(String answer) {
        return answer.equals("yes");
    }

}
