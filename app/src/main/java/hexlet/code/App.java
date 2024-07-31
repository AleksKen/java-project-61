package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;


public class App {
    private static final int NUMBER_OF_EXIT = 0;
    private static final int NUMBER_OF_GREETING = 1;
    private static final int NUMBER_OF_EVEN = 2;
    private static final int NUMBER_OF_CALC = 3;
    private static final int NUMBER_OF_GCD = 4;
    private static final int NUMBER_OF_PROGRESSION = 5;
    private static final int NUMBER_OF_PRIME = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                 Please enter the game number and press Enter.\

                1 - Greet\

                2 - Even\

                3 - Calc\

                4 - GCD\

                5 - Progression\

                6 - Prime\

                0 - Exit\

                Your choice:\s""");
        int numberGame;
        if (sc.hasNextInt()) {
            numberGame = sc.nextInt();
        } else {
            throw new IllegalArgumentException("Only digits!");
        }
        selectGame(numberGame, sc);
        sc.close();
    }

    private static void selectGame(int numberGame, Scanner sc) {
        switch (numberGame) {
            case NUMBER_OF_GREETING -> Engine.sayHello(sc);
            case NUMBER_OF_EVEN -> Even.startEven();
            case NUMBER_OF_CALC -> Calc.startCalc();
            case NUMBER_OF_GCD -> GCD.startGCD();
            case NUMBER_OF_PROGRESSION -> Progression.startProgression();
            case NUMBER_OF_PRIME -> Prime.startPrime();
            case NUMBER_OF_EXIT -> { }
            default -> throw new IllegalArgumentException("Invalid game number: " + numberGame);
        }
    }
}
