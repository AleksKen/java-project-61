package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void sayHello() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");
        sc.close();
    }
}
