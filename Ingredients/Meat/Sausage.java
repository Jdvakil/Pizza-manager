/**
 * This is the Meat subclass sausage, describes the meat.
 * 
 * @author Jay Darshan Vakil
 * @version 03/12/2020
 */
public class Sausage extends Meat {
    private final static Money newCost = new Money(2, 50);
    private final static int newCalories = 390;
    private final static String newDescription = "Sausage is meat from a pig seasoned with fennel";

    /**
     * This is the constructor it calls the super classs constructor.
     * 
     * @throws PizzaException
     */
    public Sausage() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }
}