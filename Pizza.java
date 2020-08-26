import java.util.Random;

/**
 * This class represents a pizza and it does most of the making of the pizza. It
 * puts together a pizza with its base and meat and vegetables. It also manages
 * the amount of pizza left and if you eat some pizza.
 * 
 * @author Jay Darshan Vakil
 * @version 03/12/2020
 */
public class Pizza implements PizzaComparable {
    private ArrayList<Ingredient> listOfIngredients;// The list of ingredients
    private int calorieCount; // the total calories in a pizza
    private Money totalAmount;// The total amount of the pizza
    private Shape pizzaShape;// The shape of the pizza.
    private Fraction remainPizza;// pizza remaining
    private int radius = 30;// the radius of the pizza, in cm, a medium pizza(12 inch)
    private int length = 30;// A square medium pizza

    /**
     * This is the constructor for the pizza, when it is called a new pizza is
     * created, with random ingredients and a random shape. The pizza has atleast
     * one of every ingredient and the user can add more ingredients.
     * 
     * @throws PizzaException
     */
    public Pizza() throws PizzaException {
        listOfIngredients = new ArrayList<>();

        this.totalAmount = new Money();

        this.selectShape(this.randomNum());

        this.remainPizza = new Fraction(1, 1);

        Ingredient sauce = this.generateSauce(this.randomNum());
        Ingredient cheese = this.generateCheese(this.randomNum());
        Ingredient meat = this.generateMeat(this.randomNum());
        Ingredient veg = this.generateVegetable(this.randomNum());

        this.addIngredient(sauce);
        this.addIngredient(cheese);
        this.addIngredient(meat);
        this.addIngredient(veg);

    }

    /**
     * This returns the amount of pizza that is remaining.
     * 
     * @return
     */
    public Fraction getRemainingPizza() {
        Fraction temp = this.remainPizza.clone();
        return temp;
    }

    /**
     * This method sets the remaining amount of pizza left after the pizza has been
     * eaten.
     * 
     * @param fraction
     * @throws PizzaException
     */
    public void setRemaining(Fraction fraction) throws PizzaException {
        if (fraction.compareTo(new Fraction(1, 100000)) == -1) {// setting it to 0 gave me issues so i set it to
                                                                // something very close to 0
            throw new PizzaException("Pizza cannot be less than 0");
        } else if (fraction.compareTo(new Fraction(1, 1)) == 1) {
            throw new PizzaException("Pizza fraction cannot be more than 1");
        } else {
            this.remainPizza = fraction.clone();
        }
    }

    /**
     * This returns the number of calories left in a pizza
     * 
     * @return
     */
    public int getCalorieCount() {
        int temp = this.calorieCount;
        return temp;
    }

    /**
     * This returns the amount that the pizza costs.
     * 
     * @return
     */
    public Money getTotalAmount() {
        Money temp = this.totalAmount.clone();
        return temp;
    }

    /**
     * This returns the area of the pizza, updates after a pizza is eaten.
     * 
     * @return
     */
    public double getArea() {
        double area = (double) this.getRemainingPizza().getNumerator() * (this.getPizzaShape().getArea());
        area /= (double) this.getRemainingPizza().getDenominator();
        return area;
    }

    /**
     * This is a getter for the shape of the pizza.
     * 
     * @return
     */
    public Shape getPizzaShape() {
        Shape myShape = this.pizzaShape.clone();
        return myShape;
    }

    /**
     * This is the setter for the shape, it checks if the parameter is not null.
     */
    public void setShape(Shape newShape) throws PizzaException {
        if (newShape != null) {
            this.pizzaShape = newShape.clone();
        } else {
            throw new PizzaException("Shape cannot be null");
        }
    }

    /**
     * This method adds a new ingredient to the list of ingredients in a pizza and
     * updates the calorie count and the cost of the pizza.
     * 
     * @param newIngredient
     * @throws PizzaException
     */
    public void addIngredient(Ingredient newIngredient) throws PizzaException {
        if (newIngredient != null) {
            listOfIngredients.add(newIngredient);
            this.calorieCount += newIngredient.getCalories();
            this.totalAmount.add(newIngredient.getCost());
        } else {
            throw new PizzaException("Ingredient cannot be null, please try again");
        }
    }

    /**
     * This is the method that updates the pizza fraction after a slice or a portion
     * is eaten.
     * 
     * @param eatPizza
     * @throws PizzaException
     */
    public void eatSomePizza(Fraction eatPizza) throws PizzaException {
        if (eatPizza != null) {
            if (this.getRemainingPizza().getNumerator() == 0) {
                throw new PizzaException("Pizza is finished, buy more pizza");
            }
            if (eatPizza.getNumerator() < 0) {
                throw new PizzaException("cant undo eating a pizza");
            }
            int firstFrac = this.getRemainingPizza().getNumerator() * eatPizza.getDenominator();
            int secondFrac = this.getRemainingPizza().getDenominator() * eatPizza.getNumerator();
            int difference = firstFrac - secondFrac;
            if (difference > 0) {
                int denom = this.getRemainingPizza().getDenominator() * eatPizza.getDenominator();
                this.setRemaining(new Fraction(difference, denom));
            }
            if (difference == 0) {
                throw new PizzaException("Pizza is finished");
            }
            if (difference < 0) {
                throw new PizzaException("Pizza doesnt exist anymore...");
            }
        }
    }

    /**
     * This method randomly generates a vegetable with the given option from the
     * random number generator method for the pizza.
     * 
     * @param option
     * @return
     * @throws PizzaException
     */
    private Ingredient generateVegetable(int option) throws PizzaException {
        Vegetable veg = null;
        if (option == 0) {
            veg = new Olive();
        }
        if (option == 1) {
            veg = new Pepper();
        }
        return veg;
    }

    /**
     * This method randomly generates a Meat with the given option from the random
     * number generator method for the pizza.
     * 
     * @param option
     * @return
     * @throws PizzaException
     */
    private Ingredient generateMeat(int option) throws PizzaException {
        Meat meat = null;
        if (option == 0) {
            meat = new Pepperoni();
        }
        if (option == 1) {
            meat = new Sausage();
        }
        return meat;
    }

    /**
     * This method randomly generates a Cheese with the given option from the random
     * number generator method for the pizza.
     * 
     * @param option
     * @return
     * @throws PizzaException
     */
    private Ingredient generateCheese(int option) throws PizzaException {
        Cheese cheese = null;
        if (option == 0) {
            cheese = new Mozzarella();
        }
        if (option == 1) {
            cheese = new Goat();
        }
        return cheese;

    }

    /**
     * This method randomly generates a sauce with the given option from the random
     * number generator method for the pizza.
     * 
     * @param option
     * @return
     * @throws PizzaException
     */
    private Ingredient generateSauce(int option) throws PizzaException {
        Base sauce = null;
        if (option == 0) {
            sauce = new Marinara();
        }
        if (option == 1) {
            sauce = new Alfredo();
        }
        return sauce;
    }

    /**
     * This is a random number generator that generates a number so random
     * vegetables could be chosen.
     * 
     * @return
     */
    private int randomNum() {
        Random r = new Random();
        int ret = r.nextInt(2);
        return ret;
    }

    /**
     * This method randomly selects a shape for the pizza from a random number from
     * the number generator.
     * 
     * @param option
     * @throws PizzaException
     */
    private void selectShape(int option) throws PizzaException {
        if (option == 0) {
            this.setShape(new Circle(0, 0, this.radius));
        }
        if (option == 1) {
            this.setShape(new Square(0, 0, this.length));
        }
    }

    /**
     * This method outputs the pizza in string form.
     */
    @Override
    public String toString() {
        String res = "Cost of pizza: " + this.getTotalAmount() + "; Total calories: " + this.getCalorieCount();
        res += "; Area = " + this.getArea() + "; Fraction left: " + this.getRemainingPizza() + "\ningredients:\n";
        for (int i = 0; i < this.listOfIngredients.size(); i++) {
            res += listOfIngredients.get(i) + "\n";
        }
        return res;
    }

    @Override
    /**
     * This method compares two pizza based on their cost.
     * 
     * @return -1 is this is smaller, 0 is the two are equal, and 1 if this is
     *         greater
     */
    public int compareTo(Object o) {
        Pizza obj = (Pizza) o;
        int ret = this.getTotalAmount().compareTo(obj.getTotalAmount());
        return ret;
    }

    @Override
    /**
     * This method compares two pizza objects based on their size.
     * 
     * @return -1 is this is smaller, 0 is the two are equal, and 1 if this is
     *         greater
     */
    public int compareToBySize(Object o) {
        int ret = -1;
        Pizza temp = null;
        if (o != null && o instanceof Pizza) {
            temp = (Pizza) o;
            if (this.getArea() > temp.getArea()) {
                ret = 1;
            }
            if (this.getArea() < temp.getArea()) {
                ret = -1;
            }
            if (this.getArea() == temp.getArea()) {
                ret = 0;
            }
        }
        return ret;
    }

    @Override
    /**
     * This method compares two pizza objects based on their calories.
     * 
     * @return -1 is this is smaller, 0 is the two are equal, and 1 if this is
     *         greater
     */
    public int compareToByCalories(Object o) {
        int ret = -1;
        Pizza temp = null;
        if (o != null && o instanceof Pizza) {
            temp = (Pizza) o;
            if (this.getCalorieCount() > temp.getCalorieCount()) {
                ret = 1;
            }
            if (this.getCalorieCount() < temp.getCalorieCount()) {
                ret = -1;
            }
            if (this.getCalorieCount() == temp.getCalorieCount()) {
                ret = 0;
            }
        }
        return ret;
    }
}