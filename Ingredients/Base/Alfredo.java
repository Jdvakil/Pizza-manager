/**
 * This class represents a pizza base, alfredo sauce. It extends from the base class which extends from the Ingredients class.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Alfredo extends Base {
    // Data members
    private final static Money newCost = new Money(3);//cost for the ingredient
    private final static int newCalories = 300;//number of calories present in the base
    private final static String newDescription = "Alfredo sauce, made from butter and parmesan.";//description for the base

    /**
     * This is the constructor for the base. 
     * @throws PizzaException
     */
    public Alfredo() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

}