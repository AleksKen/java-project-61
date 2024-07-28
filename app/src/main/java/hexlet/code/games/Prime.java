package hexlet.code.games;

import org.javatuples.Pair;

import java.util.Random;

public class Prime {
    private static final int RANDOM_LIMIT = 100;
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static Pair<String, String> generaQues() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_LIMIT);
        return new Pair<>(Integer.toString(randomNum), isPrime(randomNum) ? "yes" : "no");
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printRules() {
        System.out.println(RULES);
    }
}
