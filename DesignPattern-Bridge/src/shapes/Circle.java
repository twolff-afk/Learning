package shapes;

import colors.Color;

public class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "This is a circle. " + color.fill();
    }
}
