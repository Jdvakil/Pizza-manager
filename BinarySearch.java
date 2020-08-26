/**
 * This class is a support to the binary search method in the pizza manager
 * class. This is taken from my previous homework and modified.
 * 
 * @author Jay Darshan Vakil
 * @version 03/12/2020
 */
public class BinarySearch {

    /**
     * support method for the recursive search
     * 
     * @param Pizzas The arraylist of pizza
     * @param cal    The calories to look for
     * @throws PizzaException
     */
    public int recSearch(ArrayList<Pizza> pizzas, int cals) throws PizzaException {
        int len = pizzas.size();
        return recSearch(pizzas, cals, 0, len);
    }

    /**
     * This is the recursive search method's helper method that recursively searches
     * through the arraylist of pizzas.
     * 
     * @param <T>
     * @param cals The cals to find.
     * @param lhs  The left side from the middle
     * @param rhs  The right side from the middle
     * @return For this method i got help/inspiration from this website:
     *         https://www.geeksforgeeks.org/java-program-for-binary-search-recursive-and-iterative/
     * @throws PizzaException
     * 
     */
    private <T> int recSearch(ArrayList<Pizza> pizzas, Integer cals, int lhs, int rhs) throws PizzaException {
        int ret = -1;
        if (lhs > rhs) {
            throw new PizzaException();
        } else {
            int middle = (lhs + rhs) / 2;
            if (pizzas.get(middle).getCalorieCount() == cals) {
                ret = middle;
            } else if (pizzas.get(middle).getCalorieCount() > cals) {
                ret = recSearch(pizzas, cals, lhs, middle - 1);
            } else if (pizzas.get(middle).getCalorieCount() < cals) {
                ret = recSearch(pizzas, cals, middle + 1, rhs);
            } else {

            }
        }
        return ret;
    }
}