import java.util.Random;
import java.util.Scanner;

/**
 * PizzaManager Skeleton File CSS 162, Final Project
 * 
 * This class is a starting point for your final project and is incomplete. Note
 * that if there are any inconsistencies between this skeleton and the
 * assignment description, the assignment description controls.
 * 
 * Author: Rob Nash with edits by Johnny Lin
 * 
 * @author Jay Darshan Vakil
 * @version 03/12/2020
 */
public class PizzaManager {
    private static ArrayList<Pizza> pizzaList = new ArrayList<>();
    /*
     * TODO: Data definitions here.
     */

    /**
     * The console interface is defined in the start method You can exit or extend
     * the code below to accomplish all of the outcomes defined in the homework
     * document
     * 
     * @throws PizzaException
     */
    public void start() throws PizzaException {
        char selection = 'q';

        Scanner foo = new Scanner(System.in);

        while (true) {
            displayAllPizzas();
            displayInstructions();

            // foo.nextChar() doesn't exist, so now what?
            selection = foo.next().charAt(0);

            switch (selection) {
                case 'A':
                case 'a':
                    System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                    addRandomPizza();
                    break;
                case 'H':
                case 'h':
                    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                    for (int i = 0; i < 100; i++) {
                        addRandomPizza();
                    }
                    break;
                case 'E':
                case 'e':
                    System.out.println("Eating a fraction of a pizza. How much? (a/");
                    eatSomePizza(foo);
                    break;
                case 'P':
                case 'p':
                    System.out.println("Sorting pizzas by (P)rice");
                    sortByPrice();
                    break;
                case 'S':
                case 's':
                    System.out.println("Sorting pizzas by (S)ize");
                    sortBySize();
                    break;
                case 'C':
                case 'c':
                    System.out.println("Sorting pizzas by (C)alories");
                    sortByCalories();
                    break;
                case 'B':
                case 'b':
                    System.out.println(
                            "(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
                    try {
                        int cal = foo.nextInt();
                        if (cal >= 0) {
                            int found = binarySearchByCalories(cal);
                            if (found != -1) {
                                System.out.println("Pizza found with " + cal + " at: " + found);
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error with the calories, please try again...");
                    }
                    foo.nextLine();
                    break;
                case 'I':
                case 'i':
                    System.out.println("Enter the index of the pizz you want to add a new ingredient to ");
                    int index = foo.nextInt();
                    addNewIngredient(index);
                    break;
                case 'Q':
                case 'q':
                    System.out.println("(Q)uitting!");
                    System.out.println("Exitting, see ya soon!");
                    return;
                default:
                    System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * This method adds a new ingredient to the pizza list and updates the calories
     * and price.
     * 
     * @param index
     * @throws PizzaException
     */
    private static void addNewIngredient(int index) throws PizzaException {
        Random r = new Random();
        int opt = r.nextInt(2);
        Vegetable v = null;
        if (opt == 0) {
            v = new Olive();
        } else if (opt == 1) {
            v = new Pepper();
        }
        pizzaList.get(index).addIngredient(v);
    }

    /**
     * This method eats a valid fraction slice of a pizza and updates the remaining
     * pizza left.
     * 
     * @param keys
     */
    private void eatSomePizza(Scanner keys) {
        int pizzaInd;
        if (pizzaList.size() == 0) {
            System.out.println("No pizza left, make more pizza");
            return;
        }
        System.out.println("What pizza would you like to eat?: 0 to " + (pizzaList.size() - 1));
        pizzaInd = keys.nextInt();
        System.out.println();
        if (pizzaInd >= 0 || pizzaInd >= pizzaList.size()) {
            Pizza newPizza = (Pizza) pizzaList.get(pizzaInd);
            System.out.println("Please enter the numerator of the fraction: ");
            int num = keys.nextInt();
            System.out.println();
            System.out.println("Please enter the denominator of the fraction: ");
            int den = keys.nextInt();
            if (num / den == 0) {
                Fraction eatPizza = new Fraction(num, den);
                try {
                    newPizza.eatSomePizza(eatPizza);
                } catch (PizzaException pe) {
                    if (newPizza.getRemainingPizza().getNumerator() == 0) {
                        pizzaList.remove(pizzaInd);
                    } else {
                        pe.printStackTrace();
                    }
                }
            }

        }
    }

    /**
     * This makes and adds a random pizza to the list.
     */
    private void addRandomPizza() throws PizzaException {
        Pizza newPizza = new Pizza();
        pizzaList.add(newPizza);
    }

    /**
     * This displays all the pizzas in the pizza list.
     */
    private void displayAllPizzas() {
        for (int i = 0; i < pizzaList.size(); i++) {
            System.out.println(pizzaList.get(i));
        }
    }

    /**
     * This sorts the pizza list by its price.
     */
    private void sortByPrice() {
        int smallestInd;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallestInd = i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareTo(pizzaList.get(smallestInd)) == -1) {
                    smallestInd = j;
                }
            }
            Pizza smallestIndexPizza = pizzaList.get(smallestInd);
            Pizza tempPizza = pizzaList.set(smallestIndexPizza, i);
            pizzaList.set(tempPizza, smallestInd);
        }
    }

    /**
     * This sorts the pizza list by its size.
     */
    private void sortBySize() {
        int smallestInd;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallestInd = i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareToBySize(pizzaList.get(smallestInd)) == -1) {
                    smallestInd = j;
                }
            }
            Pizza smallestIndexPizza = pizzaList.get(smallestInd);
            Pizza tempPizza = pizzaList.set(smallestIndexPizza, i);
            pizzaList.set(tempPizza, smallestInd);

        }
    }

    /**
     * This sorts the pizza list by its calories.
     */
    private void sortByCalories() {
        int smallestInd;
        for (int i = 0; i < pizzaList.size(); i++) {
            smallestInd = i;
            for (int j = i; j < pizzaList.size(); j++) {
                if (((Pizza) pizzaList.get(j)).compareToByCalories(pizzaList.get(smallestInd)) == -1) {
                    smallestInd = j;
                }
            }
            Pizza smallestIndexPizza = pizzaList.get(smallestInd);
            Pizza tempPizza = pizzaList.set(smallestIndexPizza, i);
            pizzaList.set(tempPizza, smallestInd);

        }
    }

    /**
     * This binary searches through the calories to find a pizza with the same
     * calories.
     * 
     * @param cals
     * @return
     * @throws PizzaException
     */
    private int binarySearchByCalories(int cals) throws PizzaException {
        sortByCalories();
        BinarySearch b = new BinarySearch();
        int ret = b.recSearch(pizzaList, cals);
        return ret;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\nAdd a new (i)ngredient\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) throws PizzaException {
        new PizzaManager().start();
    }
}
