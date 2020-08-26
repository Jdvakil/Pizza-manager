/**
 * This represents the cheese that goes onto the pizza. 
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Cheese extends Ingredient {

    /**
     * This is the constructor, it calls the super class constuctor. 
     * @param newCost
     * @param newCalories
     * @param newDescription
     * @throws PizzaException
     */
    public Cheese(Money newCost, int newCalories, String newDescription) throws PizzaException {
        super(newCost, newCalories, newDescription);
    }
    
}