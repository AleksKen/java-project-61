package hexlet.code.games;

import org.javatuples.Pair;

import java.util.Random;

public class Even {
    private static final int RANDOM_LIMIT = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static Pair<String, String> generaQues() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_LIMIT);
        if (randomNum % 2 == 0) {
            return new Pair<>(Integer.toString(randomNum), "yes");
        } else {
            return new Pair<>(Integer.toString(randomNum), "no");
        }
    }

    public static void printRules() {
        System.out.println(RULES);
    }
}
