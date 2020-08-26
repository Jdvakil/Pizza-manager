/**
 * This class represents a fraction with two components, the numerator and the
 * denominator. Once the class gets the values from the driver class, it uses
 * greatest common denominator to simplify the following numbers into the
 * reduced fraction.
 * This class is reused from my previous homework
 * 
 * @author Jay Darshan Vakil
 * @version 03/11/2020
 */
public class Fraction implements Comparable, Cloneable {
    private int numerator;
    private int denominator;

    /**
     * This is the no argument constructor, when an instance of the class is created
     * and no argument is passed a fraction is automatically created which is 0/1 =
     * 0.
     */
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    /**
     * This is the full constructor. It takes two parameters, the numerator and the
     * denominator. Then it uses the greatest common divider to reduce the fractions
     * into its simplest form. Then it checks if the denominator if not 0 and
     * assigns the class values to the new reduced fraction.
     * 
     * @param n numerator
     * @param d denominator
     */
    public Fraction(int n, int d) {
        int gcd = 0;
        for (int i = 1; i <= n && i <= d; i++) {
            if (n % i == 0 && d % i == 0) {
                gcd = i;
            }
        }
        if (d != 0) {
            this.numerator = Math.abs(n) / gcd;
            this.denominator = Math.abs(d) / gcd;
        } else {
            throw new IllegalArgumentException("The denominator can't be 0, please recheck your fraction...");
        }
    }

    /**
     * This is the getter for the numerator.
     * 
     * @return the numerator value.
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * This is the getter for the denominator.
     * 
     * @return the denominator value.
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * This is the setter for the Numerator value.
     * 
     * @param num numerator.
     */
    public void setNumerator(int num) {
        this.numerator = num;
    }

    /**
     * This is the setter for the denominator. it checks if the parameter is not 0.
     * 
     * @param den denominator.
     */
    public void setDenominator(int den) {
        if (den != 0) {
            this.denominator = den;
        } else {
            throw new IllegalArgumentException("The denominator cannot be 0");
        }
    }

    /**
     * This is the toString method of the class, it outputs the class into a string.
     */
    @Override
    public String toString() {
        String res = "The fraction is: " + getNumerator() + "/" + getDenominator();
        return res;
    }

    /**
     * This method is the equals method for the class, it takes another fraction as
     * an input and compares to the current fraction.
     * 
     * @param otherFraction the fraction to be compared
     * @return returns true or false.
     */
    public boolean equals(Fraction otherFraction) {
        boolean res;
        double simplifiedFraction1 = this.getNumerator() / this.getDenominator();
        double simplifiedFraction2 = otherFraction.getNumerator() / otherFraction.getDenominator();
        if (simplifiedFraction1 == simplifiedFraction2) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

    @Override
    /**
     * This method return 1 if the cost of the ingredient is greater than the param,
     * 0 if the two ingredients are equal -1 if this is lesser than the param
     */
    public int compareTo(Object o) {
        int ret = -1;
        Fraction obj = (Fraction) o;
        if (this.getNumerator() > obj.getNumerator()) {
            if (this.getNumerator() > obj.getNumerator()) {
                ret = 1;
            }
        } else if (this.equals(obj)) {
            ret = 0;
        }
        return ret;
    }

    /**
     * This method clones a new fraction to prevent privacy leaks.
     */
    public Fraction clone() {
        Fraction temp = null;
        try {
            temp = (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError("Clone failed, please try again...");
        }
        return temp;
    }
}