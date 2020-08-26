import java.awt.Color;

/**
 * This is a vegetable subclass that describes the characteristics of olive
 * topping.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Olive extends Vegetable {
    private final static Money newCost = new Money(1);
    private final static int newCalories = 50;
    private final static String newDescription = "Olive is a healthy fruit that is often used on pizzas as a topping";
    private final static Color newColor = Color.black;

    /**
     * This is the constructor that calls the super constructor.
     * 
     * @throws PizzaException
     */
    public Olive() throws PizzaException {
        super(newCost, newCalories, newDescription, newColor);
    }

}