import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by David Nixon)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

// the superclass in our inheritance hierarchy
// all "common" features, functions and data should go here
// for example, all shapes in Java2D have a x,y that declares their position
// and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
// note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area 
// (future subclasses must override getArea() to provide something reasonable)
// Also, the draw method is empty too, as we don't know what shape to draw here! 
// (again, our subclasses will need to replace this method with one that actually draws things)
/**
 * This is the super class shape that inherits from Object class.
 * 
 * @author Jay Darshan Vakil
 * @version 02/10/20
 */
class Shape extends Object implements Cloneable{
	private int x = 0;
	private int y = 0;
	protected Color color;

	/**
	 * This is the empty constructor of the class
	 */
	public Shape() {
		this(0, 0, new Color(0));
	}

	/**
	 * This is the first constructor that takes in a x value and a y value.
	 * 
	 * @param a new X
	 * @param b new Y
	 */
	public Shape(int a, int b) {
		this.setX(a);
		this.setY(b);
		this.color = new Color(0);
	}

	/**
	 * This is the full constructor of the class
	 * 
	 * @param a        new X
	 * @param b        new Y
	 * @param newColor
	 */
	public Shape(int a, int b, Color newColor) {
		this.setX(a);
		this.setY(b);
		this.color = newColor;
	}

	/**
	 * This is the getter for the Area
	 * 
	 * @return -1
	 */
	public double getArea() {
		return -1;
	}

	/**
	 * This is the method to draw the shape
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
	}

	/**
	 * This is the getter for the x value
	 * 
	 * @return
	 */
	public int getX() {
		int tempX = this.x;
		return tempX;
	}

	/**
	 * This is the getter for the y value
	 * 
	 * @return
	 */
	public int getY() {
		int tempY = this.y;
		return tempY;
	}

	/**
	 * This is the setter for the X
	 * 
	 * @param newX
	 */
	protected void setX(int newX) {
		this.x = newX;
	}

	/**
	 * This is the setter fo the Y
	 * 
	 * @param newY
	 */
	protected void setY(int newY) {
		this.y = newY;
	}

	@Override
	public Shape clone(){
		Shape temp = null;
		try {
			temp = (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
            throw new InternalError("Clone failed, please try again...");
        }
		return temp;
	}
}