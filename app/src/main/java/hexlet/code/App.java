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
                               \s
                4 - GCD\

                0 - Exit\

                Your choice:\s""");
        int numberGame = sc.nextInt();
        Engine.start(sc, numberGame);
        sc.close();
    }
}
