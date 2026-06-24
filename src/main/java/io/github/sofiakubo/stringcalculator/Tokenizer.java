package io.github.sofiakubo.stringcalculator;

import java.util.List;

public class Tokenizer {

    public List<String> tokenize(String expression) {
        return List.of(expression.split(""));
    }
}
