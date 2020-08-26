import java.awt.*;

/**
 * This class represents the square.

 * @author Jay Darshan Vakil
 * @version 02/11/2020
 */
public class Square extends Shape {

    private int sideLength;

    /**
     * This is the empty constructor of the class
     */
    public Square() {
        super();
    }

    /**
     * This is the coordinate setter constructor. 
     */
    public Square(int x, int y) {
        super(x, y);
        this.setSideLength(0);
    }

    /**
     * This is the size setter for the class
     */
    public Square(int x, int y, int sideLen) {
        super(x, y);
        this.setSideLength(sideLen);
    }

    /**
     * This is the full constructor 
     * @param x
     * @param y
     * @param sideLen
     * @param color
     */
    public Square(int x, int y, int sideLen, Color color) {
        super(x, y, color);
        this.setSideLength(sideLen);
    }

    /**
     * THis is the getter for the side length
     * @return
     */
    public int getSideLength() {
        int tempSL = this.sideLength;
        return tempSL;
    }

    /**
     * This is the setter for the side length
     * PRECONDITIONS: The user will enter a valid positive number
     */
    public void setSideLength(int sideLen) {
        if (sideLen >= 0) {
            this.sideLength = sideLen;
        } else {
            throw new ArithmeticException("Side lenght cannot be less than 0");
        }
    }

    /**
     * This is the getter for the area. it overrides the getArea() in the super it returns -1
     */
    @Override
    public double getArea() {
        double area = Math.pow((double) this.getSideLength(), 2);
        return area;
    }

    /**
     * This draws the square.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawRect(getX(), getY(), this.getSideLength(), this.getSideLength());
    }
}