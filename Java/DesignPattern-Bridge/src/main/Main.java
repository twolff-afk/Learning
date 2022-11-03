package main;

import colors.Blue;
import colors.Red;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;


/*
Instead of

                        Shape
           Rectangle                    Circle
BlueRectangle   RedRectangle    BlueCircle  RedCircle

the bridge pattern does this

        shape   ------------------------->  Color
   Rectangle(Color) Circle(Color)      Blue       Red

The advantage is here, that we separat two classes and hierachies from each other.
So you do not have to create a lot of subclasses and do a composition instead.
 */
public class Main {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(new Red());
        System.out.println(rectangle.draw());


        Shape circle = new Circle(new Blue());
        System.out.println(circle.draw());

    }

}
