import java.awt.*;

/**
 * This class represents a vegetable that would go on a pizza as a topping
 * 
 * @author Jay Darshan Vakil
 * @version 03/12/2020
 */
public class Vegetable extends Ingredient {
    private Color color;

    /**
     * This is the first constructor that calls the super class without a color for
     * the vegetable.
     */
    public Vegetable(Money newCost, int newCalories, String newDescription) throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

    /**
     * This is the full constructor, it calls the super constructor and sets the
     * color for the vegetable.
     * 
     * @param newCost
     * @param newCalories
     * @param newDescription
     * @param newColor
     * @throws PizzaException
     */
    public Vegetable(Money newCost, int newCalories, String newDescription, Color newColor) throws PizzaException {
        super(newCost, newCalories, newDescription);
        this.setColor(newColor);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        Color tempColor = this.color;
        return tempColor;
    }

    /**
     * The setter for the color.
     * 
     * @param newColor
     * @throws PizzaException
     */
    private final void setColor(Color newColor) throws PizzaException {
        if (newColor != null) {
            this.color = newColor;
        } else {
            throw new PizzaException("Color cannot be null, please try again...");
        }
    }

    @Override
    /**
     * This method checks if the two vegetables are equal or not.
     */
    public boolean equals(Object obj) {
        boolean ret = false;
        if (obj instanceof Vegetable) {
            Vegetable temp = (Vegetable) obj;
            if (this.getColor().equals(temp.getColor())) {
                ret = super.equals(temp);
            }
        }
        return ret;
    }

    @Override
    /**
     * This method outputs a string to summarize the class.
     */
    public String toString() {
        String res = super.toString() + "; Color = " + this.getColor();
        return res;
    }

}