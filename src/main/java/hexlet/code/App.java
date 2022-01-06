package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                """);

        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();

        System.out.println(String.format("Your choice: %s", choice));

        switch (choice) {
            case "1" -> Cli.greeting();
            case "2" -> Even.run();
            default -> {
                return;
            }
        }
    }
}
