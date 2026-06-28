package io.github.sofiakubo.stringcalculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String expression = args[0];
        String result = calculator.calculate(expression);

        System.out.println(result);
    }
}
