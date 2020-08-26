/**
 * This is the base for the pizza, inherits from the ingredient class.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Base extends Ingredient {
    
    /**
     * This is constructor for the class, it calls the super classes constructor.
     * @throws PizzaException
     */
    public Base(Money newCost, int newCalories, String newDescription) throws PizzaException {
        super(newCost, newCalories, newDescription);
    }
    
}