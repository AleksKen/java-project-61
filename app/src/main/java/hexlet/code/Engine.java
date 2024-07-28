package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Game;
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

        Game currentGame = getGame(numberGame);
        sayHello(sc);

        if (numberGame == NUMBER_OF_GREETING) {
            return;
        }

        currentGame.printRules();
        while (countCorrectAns != ROUNDS) {
            Pair<String, String> questionAndAns = currentGame.generaQues();
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

    private static Game getGame(int numberGame) {
        return switch (numberGame) {
            case 2 -> new Even();
            case 3 -> new Calc();
            case 4 -> new GCD();
            case 5 -> new Progression();
            case 6 -> new Prime();
            default -> throw new IllegalArgumentException("Invalid game number: " + numberGame);
        };
    }
}
