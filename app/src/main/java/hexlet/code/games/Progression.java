package hexlet.code.games;

import hexlet.code.Engine;
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
        return new Pair<>(generateProgression(firstElement, difference, lengProgress, pass),
                getPassElement(firstElement, difference, pass));
    }

    private static String generateProgression(int firstElement, int difference, int length, int pass) {
        StringBuilder progression = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == pass) {
                progression.append("..");
            } else {
                progression.append(firstElement + i * difference);
            }
            if (i < length - 1) {
                progression.append(" ");
            }
        }
        return progression.toString();
    }

    private static String getPassElement(int firstElement, int difference, int pass) {
        return Integer.toString(firstElement + pass * difference);
    }

    public static void startProgression() {
        Pair<String, String>[] questionsAndAns = new Pair[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questionsAndAns[i] = generaQues();
        }
        Engine.start(RULES, questionsAndAns);
    }
}
