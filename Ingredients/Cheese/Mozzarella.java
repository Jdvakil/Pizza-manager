/**
 * This is a subclass for the subclass of ingredient. It is a type of cheese.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Mozzarella extends Cheese {
    private final static Money newCost = new Money(2);
    private final static int newCalories = 100;
    private final static String newDescription = "Mozzarella is a strechy cheese originating from Italy, it is made from a buffalos milk";

    public Mozzarella() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

}