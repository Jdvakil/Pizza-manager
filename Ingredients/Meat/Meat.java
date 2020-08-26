/**
 * This is  the meat category for the pizza.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Meat extends Ingredient{

    /**
     * This is the constructor for the class, it is called by the subclasses.
     * @param newCost the cost of the meat
     * @param newCalories the number of calories
     * @param newDescription the description of the meat.
     * @throws PizzaException
     */
    public Meat(Money newCost, int newCalories, String newDescription) throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

    
}