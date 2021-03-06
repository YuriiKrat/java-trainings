package ua.kpi.training;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents model object in MVC pattern
 *
 * @author Yurii Krat
 * @version 1.0, 30.10.2016
 */
public class Model {

    /**
     * The value generated by computer
     */
    private int computerValue;

    /**
     * Left bound of the interval
     */
    private int minValue;

    /**
     * Right bound of the interval
     */
    private int maxValue;

    /**
     * List of user's input values
     */
    private List<Integer> userValues;

    /**
     * Default constructor.
     * Creates list object {@link #userValues}
     */
    public Model() {
        userValues = new ArrayList<>();
    }

    /**
     * Returns integer value generated by computer
     * @return computer's generated value
     */
    public int getComputerValue() {
        return computerValue;
    }

    /**
     * Sets integer value generated by computer
     */
    public void setComputerValue() {
        computerValue = (int)(Math.random() * (maxValue - minValue - 1) + minValue + 1);
    }

    /**
     * Sets integer value generated by computer
     */
    public void setComputerValue(int computerValue) {
        this.computerValue = computerValue;
    }

    /**
     * Returns integer value which is the left bound of the interval
     * @return minimal value of a range
     */
    public int getMinValue() {
        return minValue;
    }

    /**
     * Sets integer values which are bounds of the interval
     * @param minValue minimal value of a range
     * @param maxValue maximal value of a range
     * @return true if minimal value is less than maximal value, otherwise false
     */
    public boolean setLimits(int minValue, int maxValue) {
        if (minValue >= maxValue - 1) {
            return false;
        } else {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
        return true;
    }

    /**
     * Returns integer value which is the right bound of the interval
     * @return maximal value of a range
     */
    public int getMaxValue() {
        return maxValue;
    }

    /**
     * Returns a list of user's game attempts
     * @return list of user's input values
     */
    public List<Integer> getUserValues() {
        return userValues;
    }

    /**
     * Sets a list of user's game attempts
     * @param userValues list of user's input values
     */
    public void setUserValues(List<Integer> userValues) {
        this.userValues = userValues;
    }

    /**
     * Checks if user's value is equal to computer generated value
     * @param userValue value input by user
     * @return true if user value is equal to computer value, otherwise false
     */
    public boolean checkMoreOrLess(int userValue) {
        if (userValue == computerValue){
            return true;
        } else if(userValue > computerValue) {
            maxValue = userValue;
        } else {
            minValue = userValue;
        }
        return false;
    }

    /**
     * Checks if user number is in a range
     * @param inputNumber number input by user
     * @return true if input number is in a range, otherwise false
     */
    public boolean checkRange(int inputNumber) {
        if (inputNumber >= maxValue || inputNumber <= minValue) {
            return false;
        }
        return true;
    }
}
