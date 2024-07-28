package hexlet.code;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the game number and press Enter.\n1 - Greet\n2 - Even\n0 - Exit\nYour choice: ");
        int numberGame = sc.nextInt();
        if (numberGame == 1) {
            Engine.sayHello(sc);
        }
        else if (numberGame == 2) {
            Engine.startEven(sc);
        }
        sc.close();
    }
}
