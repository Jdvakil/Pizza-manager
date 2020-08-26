/**
 * This is the meat subclass of the ingredients that go on the pizza.
 */
public class Pepperoni extends Meat {
    private final static Money newCost = new Money(4, 50);
    private final static int newCalories = 300;
    private final static String newDescription = "Pepperoni is a type of meat that is round and red, made from pork or beef seasoned with chili powder";

    /**
     * This is the constructor for the class, calls the super constructor.
     * 
     * @throws PizzaException
     */
    public Pepperoni() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }
}