package io.github.sofiakubo.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public List<String> tokenize(String expression) {
        StringBuilder buffer = new StringBuilder();
        List<String> tokens = new ArrayList<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                buffer.append(c);
            } else {
                tokens.add(buffer.toString());
                buffer.setLength(0);
                tokens.add(String.valueOf(c));
            }
        }

        if (!buffer.isEmpty()) {
            tokens.add(buffer.toString());
        }
        return tokens;
    }
}
