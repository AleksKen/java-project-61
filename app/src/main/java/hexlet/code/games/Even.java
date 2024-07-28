package hexlet.code.games;

import java.util.Random;

public class Even {
    private static final int RANDOM_LIMIT = 100;
    public static String generQues() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_LIMIT);
        System.out.println("Question: " + randomNum);
        if (randomNum % 2 == 0)
            return "yes";
        else
            return "no";
    }
}
