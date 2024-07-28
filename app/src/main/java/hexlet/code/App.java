package hexlet.code;

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
        Engine.start(sc, numberGame);
        sc.close();
    }
}
