import java.awt.*;

/**
 * This class represents the circle. This class is used from my previous homework.
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Circle extends Shape {
    private int radius;

    /**
     * This is the empty constructor
     */
    public Circle() {
        super();
    }

    /**
     * This is the constructor without the color specified
     */
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.setRadius(radius);
    }

    /**
     * This is the full constructor for the class
     * @param x
     * @param y
     * @param radius
     * @param color
     */
    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.setRadius(radius);
    }

    /**
     * This is the getter for the area, it overrides the super getArea() which return -1.
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    /**
     * This is the getter for the radius 
     * @return
     */
    public int getRadius() {
        int tempR = this.radius;
        return tempR;
    }

    /**
     * This is the setter for the radius 
     * @param rad
     * PRECONDITIONS: The user will enter a valid positive number
     */
    public void setRadius(int rad) {
        if (rad >= 0) {
            this.radius = rad;
        } else {
            throw new ArithmeticException("Radius cannot be less than 0");
        }
    }

    /**
     * THis is the draw method which draws the circle upon class call.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawOval(getX(), getY(), this.getRadius(), this.getRadius());
    }
}