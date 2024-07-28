package hexlet.code.games;

import org.javatuples.Pair;

import java.util.Random;

public class Progression {
    private static final int LIMIT_DIFFERENCE = 30;
    private static final int LIMIT_FIRST = 25;
    private static final int MIN_LENG = 5;
    private static final int MAX_LENG = 10;
    private static final String RULES = "What number is missing in the progression?";

    public static Pair<String, String> generaQues() {
        Random random = new Random();
        int difference = random.nextInt(LIMIT_DIFFERENCE);
        int firstElement = random.nextInt(LIMIT_FIRST);
        int lengProgress = random.nextInt(MAX_LENG - MIN_LENG + 1) + MIN_LENG;
        int pass = random.nextInt(lengProgress);

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < lengProgress; i++) {
            if (i == pass) {
                question.append("..");
            } else {
                question.append(firstElement + i * difference);
            }
            if (i < lengProgress - 1) {
                question.append(" ");
            }
        }
        return new Pair<>(question.toString(), Integer.toString(firstElement + pass * difference));
    }

    public static void printRules() {
        System.out.println(RULES);
    }
}
