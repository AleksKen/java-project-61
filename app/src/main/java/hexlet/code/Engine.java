package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import org.javatuples.Pair;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS = 3;
    private static final int NUMBER_OF_EXIT = 0;
    private static final int NUMBER_OF_GREETING = 1;
    private static int countCorrectAns;
    private static String namePlayer;

    public static void start(Scanner sc, int numberGame) {
        if (numberGame == NUMBER_OF_EXIT) {
            return;
        }

        sayHello(sc);

        if (numberGame == NUMBER_OF_GREETING) {
            return;
        }

        printCurRules(numberGame);
        while (countCorrectAns != ROUNDS) {
            Pair<String, String> questionAndAns = getQuestAndAns(numberGame);
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
                return;
            }
        }
        System.out.println("Congratulations, " + namePlayer + "!");
    }

    private static void sayHello(Scanner sc) {
        System.out.print("Welcome to the Brain Games!\n" + "May I have your name? ");
        namePlayer = sc.next();
        System.out.println("Hello, " + namePlayer + "!");
    }

    private static void printCurRules(int numberGame) {
        switch (numberGame) {
            case 2 -> Even.printRules();
            case 3 -> Calc.printRules();
            case 4 -> GCD.printRules();
            case 5 -> Progression.printRules();
            case 6 -> Prime.printRules();
            default -> throw new IllegalArgumentException("Invalid game number: " + numberGame);
        }
    }

    private static Pair<String, String> getQuestAndAns(int numberGame) {
        return switch (numberGame) {
            case 2 -> Even.generaQues();
            case 3 -> Calc.generaQues();
            case 4 -> GCD.generaQues();
            case 5 -> Progression.generaQues();
            case 6 -> Prime.generaQues();
            default -> throw new IllegalArgumentException("Invalid game number: " + numberGame);
        };
    }
}
