/**
 * This is a cheese ingredient that goes on the pizza.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Goat extends Cheese{

    //data members
    private final static Money newCost = new Money(3);
    private final static int newCalories = 100;
    private final static String newDescription = "Goat cheese is cheese made from goats milk.";

    /**
     * The constuctor for the class, it calls the super classs' contructor
     * @throws PizzaException
     */
    public Goat() throws PizzaException {
        super(newCost, newCalories, newDescription);
    }

    
}