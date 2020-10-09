package com.example.cars4sale;

public class MyTokenizer extends Tokenizer {
    static final char[] whitespace = {' ', '\n', '\t'};
    static final char[] symbol = {'<', '>', '=', ';'};

    private String text;
    private int pos;
    private Object current;

    public MyTokenizer(String text) {
        this.text = text;
        this.pos = 0;
        next();
    }

    /**
     * Remove white space in a sequence until there's no whitespace in the current position
     */
    private void removeWhite() {
        while (pos < text.length() && isIn(text.charAt(pos), whitespace))
            pos++;
    }

    private boolean isIn(char c, char[] charList) {
        for (char w : charList) {
            if (w == c) {
                return true;
            }
        }
        return false;
    }


    public Object current() {
        return current;
    }

    public boolean hasNext() {
        return current != null;
    }

    /**
     * Extract next token starting from the current position {@code pos}.
     * The extracted token is saved in {@code self.current}.
     */
    public void next() {
        removeWhite();
        if (pos == text.length()) {
            current = null;

        } else if (isIn(text.charAt(pos), symbol)) {
            current = "" + text.charAt(pos);
            pos++;

        } else if (Character.isDigit(text.charAt(pos))) {
            int start = pos;
            while (pos < text.length() && Character.isDigit(text.charAt(pos)))
                pos++;

            // check period in a sequence. Note that valid double has only single period in a seq
            if (pos + 1 < text.length() && text.charAt(pos) == '.' &&
                    Character.isDigit(text.charAt(pos + 1))) {
                pos++;
                while (pos < text.length() && Character.isDigit(text.charAt(pos)))
                    pos++;
                current = Double.parseDouble(text.substring(start, pos));
            } else {
                current = Integer.parseInt(text.substring(start, pos));
            }

        } else {
            // parse string
            int start = pos;
            while (pos < text.length() && !isIn(text.charAt(pos), symbol)
                    && !isIn(text.charAt(pos), whitespace))
                pos++;
            current = text.substring(start, pos);
        }
    }
}
