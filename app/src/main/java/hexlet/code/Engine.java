package hexlet.code;

import hexlet.code.games.Even;
import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;
    private static int countCorrectAns;
    private static String namePlayer;

    public static void sayHello(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        namePlayer = sc.next();
        System.out.println("Hello, " + namePlayer + "!");
    }

    public static void startEven(Scanner sc) {
        sayHello(sc);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (countCorrectAns != ROUNDS){
            String correctAns = Even.generQues();
            System.out.print("Your answer: ");
            String ans = sc.next();
            if (ans.equals(correctAns)) {
                System.out.println("Correct!");
                countCorrectAns++;
            }
            else {
                System.out.println("'" + ans + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAns + "'" +".");
                countCorrectAns = 0;
                System.out.println("Let's try again, " + namePlayer + "!");
            }
        }
        System.out.println("Congratulations, " + namePlayer + "!");
    }
}
