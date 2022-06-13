package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapeFactory {

    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape theShape;
        Random random = new Random();
        int chosen = random.nextInt(3);

        if(chosen == 0)
            theShape = new Triangle();
        else if(chosen == 1)
            theShape = new Circle();
        else
            theShape = new Square();

        return theShape;
    }
}
