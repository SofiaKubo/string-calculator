package io.github.sofiakubo.stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenizerTest {
    @Test
    void tokenizesSingleDigitNumbers() {
        final Tokenizer tokenizer = new Tokenizer();

        final List<String> result = tokenizer.tokenize("2+3");

        assertThat(result)
                .containsExactly("2", "+", "3");
    }

    @Test
    void tokenizesMultipleDigitNumbers() {
        final Tokenizer tokenizer = new Tokenizer();

        final List<String> result = tokenizer.tokenize("222+333");

        assertThat(result)
                .containsExactly("222", "+", "333");
    }
}
