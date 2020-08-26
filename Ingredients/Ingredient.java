/**
 * This class represents an ingredient on a pizza, every ingredient has a cost,
 * calorie count a description, that are the data members in this class.
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Ingredient implements Comparable<Ingredient> {
    private Money cost;// The cost of the ingredient.
    private int calories;// The number of calories in the ingredient
    private String description;// The description of the ingredient

    /**
     * This is the constructor for the class, it takes in the cost, description and
     * the description and sets it to the data of the class.
     * 
     * @param newCost        the new cost of the ingredient
     * @param newCalories    The calories of thr ingredient
     * @param newDescription The descrition of the ingredient
     * @throws PizzaException
     */
    public Ingredient(Money newCost, int newCalories, String newDescription) throws PizzaException {
        this.setCost(newCost);
        this.setCalories(newCalories);
        this.setDescription(newDescription);
    }

    /**
     * The getter for the calories.
     * 
     * @return the calories
     */
    public int getCalories() {
        int tempCalories = this.calories;
        return tempCalories;
    }

    /**
     * The getter for the description.
     * 
     * @return the description
     */
    public String getDescription() {
        String tempDescription = this.description;
        return tempDescription;
    }

    /**
     * The getter for the cost.
     * 
     * @return the cost
     */
    public Money getCost() {
        Money tempMoney = this.cost.clone();
        return tempMoney;
    }

    /**
     * This sets the new description. Checks if the description is not empty.
     * 
     * @param newDescription the description to set
     * @throws PizzaException if the new description is empty.
     */
    private final void setDescription(String newDescription) throws PizzaException {
        if (!newDescription.isEmpty()) {
            this.description = newDescription;
        } else {
            throw new PizzaException("New description cannot be empty, please try again...");
        }
    }

    /**
     * The setter for the cost. Checks if the new money object is null.
     * 
     * @param newCost the cost to set
     * @throws PizzaException
     */
    private final void setCost(Money newCost) throws PizzaException {
        if (newCost != null) {
            this.cost = newCost.clone();
        } else {
            throw new PizzaException("New cost cannot be null, please try again...");
        }
    }

    /**
     * The setter for the calories. Checks if the new calories is positive or not.
     * 
     * @param newCalories the calories to set
     * @throws PizzaException
     */
    private final void setCalories(int newCalories) throws PizzaException {
        if (newCalories >= 0) {
            this.calories = newCalories;
        } else {
            throw new PizzaException("Calories cannot be less than 0...");
        }
    }

    @Override
    /**
     * This is the equals method, it takes in an object and checks if the object is
     * equal to this class or not.
     * 
     * @param obj The object to compare.
     * @return true or false.
     */
    public boolean equals(Object obj) {
        boolean ret = false;
        Ingredient temp = null;
        if (obj instanceof Ingredient && obj != null) {
            temp = (Ingredient) obj;
            if (this.getCalories() == temp.getCalories()) {
                if (this.getDescription().equals(temp.getDescription())) {
                    if (this.getCost().equals(temp.getCost())) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    /**
     * This method return 1 if the cost of the ingredient is greater than the param, 0 if the two ingredients are equal
     * -1 if this is lesser than the param 
     * 
     * @param o The other ingredient to compare to.
     * @return 
     */
    public int compareTo(Ingredient o) {
        int ret = this.getCost().compareTo(o.getCost());
        return ret;
    }

    @Override
    /**
     * This method outputs the class in a string form.
     */
    public String toString() {
        String ret = "Description = " + this.getDescription() + "; Cost = " + this.getCost() + "; Calories = ";
        ret += this.getCalories();
        return ret;
    }
}