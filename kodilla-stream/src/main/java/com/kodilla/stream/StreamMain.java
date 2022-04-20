package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Text to decorate.", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("Text to decorate.", (text) -> text.toUpperCase());
        poemBeautifier.beautify("Text to decorate.",
                (text) -> text.replace(' ', '*'));
        poemBeautifier.beautify("Text to decorate.", PoemDecorator :: starText);
    }
}