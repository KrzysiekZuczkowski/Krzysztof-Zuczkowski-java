package com.kodilla.stream.beautifier;

public interface PoemDecorator {

    String decorate(String text);

    static String starText(String text) {
        return "*** " + text + " ***";
    }
}
