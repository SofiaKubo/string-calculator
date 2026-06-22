package io.github.sofiakubo.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @Test
    void calculatesExpression() {
        final Calculator calculator = new Calculator();

        final String result = calculator.calculate("222+333*444");

        assertThat(result)
                .isEqualTo("148074");
    }
}
