package hexlet.code.games;

import hexlet.code.Engine;
import org.javatuples.Pair;

import java.util.Random;

public class Calc {
    private static final int RANDOM_LIMIT = 100;
    private static final int NUMBER_OPERATORS = 3;
    private static final String RULES = "What is the result of the expression?";

    public static Pair<String, String> getPairQuestAndAns() {
        Random random = new Random();
        String[] operators = {" - ", " + ", " * "};
        int randomOperand1 = random.nextInt(RANDOM_LIMIT);
        int randomOperand2 = random.nextInt(RANDOM_LIMIT);
        String randomOperator = operators[random.nextInt(NUMBER_OPERATORS)];
        int res = calculateResult(randomOperator, randomOperand1, randomOperand2);
        return new Pair<>(randomOperand1 + randomOperator + randomOperand2, Integer.toString(res));
    }

    private static int calculateResult(String operator, int operand1, int operand2) {
        return switch (operator) {
            case " - " -> operand1 - operand2;
            case " + " -> operand1 + operand2;
            case " * " -> operand1 * operand2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }

    public static void startCalc() {
        Pair<String, String>[] questionsAndAns = new Pair[Engine.ROUNDS];
        for (int i = 0; i < Engine.ROUNDS; i++) {
            questionsAndAns[i] = getPairQuestAndAns();
        }
        Engine.start(RULES, questionsAndAns);
    }
}
