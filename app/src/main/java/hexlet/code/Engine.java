package hexlet.code;

import org.javatuples.Pair;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    private static String namePlayer;

    public static void start(String gameRules,  Pair<String, String>[] questionsAndAns) {
        Scanner sc = new Scanner(System.in);

        sayHello(sc);

        System.out.println(gameRules);
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Question: " + questionsAndAns[i].getValue0());
            System.out.print("Your answer: ");
            String ans = sc.next();
            if (ans.equals(questionsAndAns[i].getValue1())) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + ans + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + questionsAndAns[i].getValue1() + "'" + ".");
                System.out.println("Let's try again, " + namePlayer + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + namePlayer + "!");
    }

    public static void sayHello(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        namePlayer = sc.next();
        System.out.println("Hello, " + namePlayer + "!");
    }
}
