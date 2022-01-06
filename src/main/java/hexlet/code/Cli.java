package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println(String.format("Hello, %s!", name));

        return name;
    }
}
