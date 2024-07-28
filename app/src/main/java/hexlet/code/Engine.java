package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import org.javatuples.Pair;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;
    private static final int NUMBER_OF_EXIT = 0;
    private static int countCorrectAns;
    private static String namePlayer;

    public static void start(Scanner sc, int numberGame) {
        if (numberGame == NUMBER_OF_EXIT) {
            return;
        }
        sayHello(sc);
        chooseRules(numberGame);

        while (countCorrectAns != ROUNDS) {
            Pair<String, String> questionAndAns;
            switch (numberGame) {
                case 2 -> {
                    questionAndAns = Even.generQues();
                }
                case 3 -> {
                    questionAndAns = Calc.generQues();
                }
                default -> {
                    return;
                }
            }
            System.out.println("Question: " + questionAndAns.getValue0());
            System.out.print("Your answer: ");
            String ans = sc.next();
            if (ans.equals(questionAndAns.getValue1())) {
                System.out.println("Correct!");
                countCorrectAns++;
            } else {
                System.out.println("'" + ans + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + questionAndAns.getValue1() + "'" + ".");
                countCorrectAns = 0;
                System.out.println("Let's try again, " + namePlayer + "!");
            }
        }
        System.out.println("Congratulations, " + namePlayer + "!");
    }

    private static void sayHello(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        namePlayer = sc.next();
        System.out.println("Hello, " + namePlayer + "!");
    }

    private static void chooseRules(int numberGame) {
        switch (numberGame) {
            case 2 -> Even.printRules();
            case 3 -> Calc.printRules();
            default -> System.out.println();
        }
    }
}
