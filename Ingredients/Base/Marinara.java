/**
 * This is a base sauce for the pizza, it inherits from the base class/
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Marinara extends Base {

    private final static Money newCost = new Money(1, 50);
    private final static int newCalories = 65;
    private final static String newDescription = "Marinara sauce, this is made from tomatoes and it is red";

    /**
     * This is the constructor, it calls the base constructor. 
     * @throws PizzaException
     */
    public Marinara() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

}