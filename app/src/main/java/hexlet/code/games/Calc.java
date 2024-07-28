package hexlet.code.games;

import org.javatuples.Pair;

import java.util.Random;

public class Calc {
    private static final int RANDOM_LIMIT = 100;
    private static final int NUMBER_OPERATORS = 3;
    private static final String RULES = "What is the result of the expression?";

    public static Pair<String, String> generQues() {
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
            default -> 0;
        };
    }

    public static void printRules() {
        System.out.println(RULES);
    }
}
