package hexlet.code.games;

import java.util.Objects;
import java.util.Scanner;

public class Progression {

    public static void run(String name, int numberOfLaps) {
        Progression.printRules();

        for (var i = 0; i < numberOfLaps; i++) {
            var question = Progression.getQuestion();
            System.out.printf("Question: %s%n", question);

            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();

            int correctAnswer = Progression.progression(question);
            boolean answerIsCorrect = Integer.parseInt(answer) == correctAnswer;

            if (!answerIsCorrect) {
                Progression.printWrongAnswer(answer, Integer.toString(correctAnswer), name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", name);
    }

    private static int progression(String question) {
       String[] numbers = question.split(" ");
       int missingNumberIndex = 0;

        for (var i = 0; i < numbers.length; i++) {
            if (Objects.equals(numbers[i], "..")) {
                missingNumberIndex = i;
                break;
            }
        }

        int missingNumber = Integer.parseInt(numbers[missingNumberIndex - 1]);

        if (missingNumberIndex < 2) {
            return Integer.parseInt(numbers[4]) - Integer.parseInt(numbers[3]) + missingNumber;
        }

        return Integer.parseInt(numbers[1]) - Integer.parseInt(numbers[0]) + missingNumber;
    }

    private static String getQuestion() {
        final int minimumProgressionLength = 5;
        final int minimumNumber = 10;

        var progressionNumber = (int) (Math.random() * minimumNumber);
        var number = (int) (Math.random() * minimumNumber);
        var progressionLength = (int) (Math.random() * minimumProgressionLength) + minimumProgressionLength;

        var progressionNumbers = new String[progressionLength];
        var index = 0;

        for (var i = 0; i < progressionLength; i++) {
            number += progressionNumber;
            progressionNumbers[index] = Integer.toString(number);

            index++;
        }

        var randomIndex = (int) (Math.random() * progressionLength);
        progressionNumbers[randomIndex] = "..";

        return String.join(" ", progressionNumbers);
    }

    private static void printWrongAnswer(String answer, String correctAnswer, String name) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
        System.out.printf("Let's try again, %s!%n", name);
    }

    private static void printRules() {
        System.out.println("What number is missing in the progression?");
    }

}
