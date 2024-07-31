package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;


public class App {
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
            case 1 -> Engine.sayHello(sc);
            case 2 -> Even.startEven();
            case 3 -> Calc.startCalc();
            case 4 -> GCD.startGCD();
            case 5 -> Progression.startProgression();
            case 6 -> Prime.startPrime();
            case 0 -> { }
            default -> throw new IllegalArgumentException("Invalid game number: " + numberGame);
        }
    }
}
