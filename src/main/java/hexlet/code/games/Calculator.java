package hexlet.code.games;

import java.util.Scanner;

public class Calculator {

    public static void run(String name, int numberOfLaps) {
        Calculator.printRules();

        for (var i = 0; i < numberOfLaps; i++) {
            var question = Calculator.getQuestion();
            System.out.printf("Question: %s%n", question);

            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();

            int correctAnswer = Calculator.calculateCorrectAnswer(question);
            boolean answerIsCorrect = Integer.parseInt(answer) == correctAnswer;

            if (!answerIsCorrect) {
                Calculator.printWrongAnswer(answer, Integer.toString(correctAnswer), name);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", name);
    }

    private static int calculateCorrectAnswer(String question) {
        String[] splitQuestion = question.split(" ");
        int leftOperand = Integer.parseInt(splitQuestion[0]);
        var operation = splitQuestion[1];
        int rightOperand = Integer.parseInt(splitQuestion[2]);

        switch (operation) {
            case "*":
                return leftOperand * rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "+":
                return leftOperand + rightOperand;
            default:
                return 0;
        }
    }

    private static String getQuestion() {
        final int maximumNumber = 20;
        var operations = new String[]{"-", "+", "*"};
        var leftOperand = (int) (Math.random() * maximumNumber);
        var rightOperand = (int) (Math.random() * maximumNumber);

        return String.format(
                "%d %s %d", leftOperand, operations[(int) (Math.random() * operations.length)], rightOperand
        );
    }

    private static void printWrongAnswer(String answer, String correctAnswer, String name) {
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
        System.out.printf("Let's try again, %s!%n", name);
    }

    private static void printRules() {
        System.out.println("What is the result of the expression?");
    }
}
