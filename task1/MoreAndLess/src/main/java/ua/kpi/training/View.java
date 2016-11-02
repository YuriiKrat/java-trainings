package ua.kpi.training;

import java.util.List;

/**
 * This class represents view in MVC pattern
 *
 * @author Yurii Krat
 * @version 1.0, 30.10.2016
 */
public class View {

    // Text's constants
    public static final String WELCOME_STRING = "Welcome to the game \"More And Less!\"";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please!";
    public static final String WRONG_INPUT_DATA_RANGE = "Wrong range! Repeat please!";
    public static final String ENTER_NUMBER = "Please, enter the number in the range from %d to %d:\n";
    public static final String VICTORY = "Congratulation! You won!";
    public static final String ENTER_MIN = "Enter minimal value of the range: ";
    public static final String ENTER_MAX = "Enter maximal value of the range: ";
//    public static final String LESS_THAN = "Your number is smaller than correct number!";
//    public static final String MORE_THAN = "Your number is bigger than correct number!";
    private static final String ATTEMPTS = "You made %d attempts: ";

    /**
     * Prints message in console
     * @param message text message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Prints message with formatted output in console
     * @param message text message
     * @param value1 first integer value
     * @param value2 second integer value
     */
    public void printMessageAndTwoInts(String message, int value1, int value2){
        System.out.printf(message, value1, value2);
    }

    /**
     * Prints list of user's attempts in console
     * @param userValues list of user's entered values
     */
    public void printAttempts(List<Integer> userValues) {
        System.out.printf(ATTEMPTS, userValues.size());
        for (int value: userValues) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
