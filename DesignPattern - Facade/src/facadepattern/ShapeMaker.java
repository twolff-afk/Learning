package facadepattern;

/**
 * This class acts as a facade to hide the complexity
 */
public class ShapeMaker {

    private shape rectangle;
    private shape square;
    private shape circle;

    public ShapeMaker() {
        rectangle = new Rectangle();
        square = new Square();
        circle = new Circle();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawCircle() {
        circle.draw();
    }
}
