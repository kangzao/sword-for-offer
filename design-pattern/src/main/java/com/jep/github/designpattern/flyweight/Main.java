package com.jep.github.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ColorFactory colorFactory = new ColorFactory();

        Color red = colorFactory.getColor("red");
        red.fillColor();

        Color blue = colorFactory.getColor("blue");
        blue.fillColor();

        Color red2 = colorFactory.getColor("red");
        red2.fillColor();
    }
}


class ColorFactory {
    private Map<String, Color> colorMap;

    public ColorFactory() {
        colorMap = new HashMap<>();
    }

    public Color getColor(String colorName) {
        Color color = colorMap.get(colorName);

        if (color == null) {
            color = new ConcreteColor(colorName);
            colorMap.put(colorName, color);
            System.out.println("Creating new color: " + colorName);
        }

        return color;
    }
}

class ConcreteColor implements Color {
    private String color;

    public ConcreteColor(String color) {
        this.color = color;
    }

    @Override
    public void fillColor() {
        System.out.println("Filling color: " + color);
    }
}
