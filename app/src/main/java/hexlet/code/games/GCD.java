package hexlet.code.games;

import hexlet.code.Engine;
import org.javatuples.Pair;

import java.util.Random;

public class GCD {
    private static final int RANDOM_LIMIT = 100;
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static Pair<String, String> generaQues() {
        Random random = new Random();
        int randomOperand1 = random.nextInt(RANDOM_LIMIT);
        int randomOperand2 = random.nextInt(RANDOM_LIMIT);
        int res = gcdEuclid(randomOperand1, randomOperand2);
        return new Pair<>(randomOperand1 + " " + randomOperand2, Integer.toString(res));
    }

    private static int gcdEuclid(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdEuclid(num2, num1 % num2);
    }

    public static void startGCD() {
        Pair<String, String>[] questionsAndAns = new Pair[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questionsAndAns[i] = generaQues();
        }
        Engine.start(RULES, questionsAndAns);
    }
}
