package shapes;

import colors.Color;

public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "This is a rectangle. " + color.fill();
    }
}
