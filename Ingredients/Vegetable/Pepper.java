import java.awt.*;

/**
 * This is vegetable subclass, it describes a pepper topping.
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Pepper extends Vegetable{
    private final static Money newCost = new Money(1);
    private final static int newCalories = 20;
    private final static String newDescription = "It is also called bell pepper, has a sour sweet taste";
    private final static Color newColor = Color.YELLOW;
    
    /**
     * This is the constructor, it calls the super constructor. 
     * @throws PizzaException
     */
    public Pepper() throws PizzaException {
        super(newCost, newCalories, newDescription, newColor);
    }
    
}