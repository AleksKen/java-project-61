package hexlet.code.games;

import hexlet.code.Engine;
import org.javatuples.Pair;

import java.util.Random;

public class Even {
    private static final int RANDOM_LIMIT = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static Pair<String, String> generaQues() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_LIMIT);
        return new Pair<>(Integer.toString(randomNum), isEven(randomNum) ? "yes" : "no");
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void startEven() {
        Pair<String, String>[] questionsAndAns = new Pair[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questionsAndAns[i] = generaQues();
        }
        Engine.start(RULES, questionsAndAns);
    }
}
