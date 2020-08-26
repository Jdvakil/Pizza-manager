/**
 * This class is the exception for the pizza simulator, it displays a message specific to the pizza simulator
 * instead of the default runtime exception.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class PizzaException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * The empty constructor, it displays a default message in relation with the pizza simulator
     */
    public PizzaException() {
        super("Error with the pizza simulator, please try again...");
    }

    /**
     * This is the constructor that displays the message chosen by the user. 
     * @param message
     */
    public PizzaException(String message){
        super(message);
    }
}