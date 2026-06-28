package io.github.sofiakubo.stringcalculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculator {
    public String calculate(String expression) {
        final Tokenizer tokenizer = new Tokenizer();
        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        List<String> tokens = tokenizer.tokenize(expression);

        for (String token : tokens) {
            char firstChar = token.charAt(0);
            if (Character.isDigit(firstChar)) {
                numbers.push(Integer.parseInt(token));
            } else {
                char currentOperator = firstChar;

                while (!operators.isEmpty() && priority(operators.peek()) >=
                        priority(currentOperator)) {
                    executeTopOperation(numbers, operators);
                }
                operators.push(currentOperator);
            }
        }
        while (!operators.isEmpty()) {
            executeTopOperation(numbers, operators);
        }
        return String.valueOf(numbers.pop());
    }

    private int priority(char operator) {
        if (operator == '+') {
            return 1;
        }

        if (operator == '*') {
            return 2;
        }
        return 0;
    }

    private void executeTopOperation(Deque<Integer> numbers, Deque<Character> operators) {
        int rightOperand = numbers.pop();
        int leftOperand = numbers.pop();
        char operator = operators.pop();

        int result = switch (operator) {
            case '+' -> leftOperand + rightOperand;
            case '*' -> leftOperand * rightOperand;
            default -> throw new IllegalStateException(
                    "Unknown operation: " + operator);
        };
        numbers.push(result);
    }
}
