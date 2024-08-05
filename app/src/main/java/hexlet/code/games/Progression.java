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

    public static Pair<String, String> getPairQuestAndAns() {
        Random random = new Random();
        int difference = random.nextInt(LIMIT_DIFFERENCE);
        int firstElement = random.nextInt(LIMIT_FIRST);
        int lengProgress = random.nextInt(MAX_LENG - MIN_LENG + 1) + MIN_LENG;
        int pass = random.nextInt(lengProgress);
        return new Pair<>(maskProgressionElement(generateProgression(firstElement, difference, lengProgress), pass),
                getPassElement(firstElement, difference, pass));
    }

    private static int[] generateProgression(int firstElement, int difference, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = firstElement + i * difference;
        }
        return progression;
    }

    private static String maskProgressionElement(int[] progression, int pass) {
        StringBuilder progressionWithPass = new StringBuilder();
        for (int i = 0; i < progression.length; i++) {
            if (i == pass) {
                progressionWithPass.append("..");
            } else {
                progressionWithPass.append(progression[i]);
            }
            if (i < progression.length - 1) {
                progressionWithPass.append(" ");
            }
        }
        return progressionWithPass.toString();
    }

    private static String getPassElement(int firstElement, int difference, int pass) {
        return Integer.toString(firstElement + pass * difference);
    }

    public static void startProgression() {
        Pair<String, String>[] questionsAndAns = new Pair[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questionsAndAns[i] = getPairQuestAndAns();
        }
        Engine.start(RULES, questionsAndAns);
    }
}
