package ua.kpi.training;

/**
 * This class represents view in MVC pattern
 *
 * @author Yurii Krat
 * @version 1.0, 06.11.2016
 */
public class View {

    // Text's constants
    public static final String ENTER_LAST_NAME = "Enter last name:";
    public static final String ENTER_FIRST_NAME = "Enter first name:";
    public static final String ENTER_PATRONYMIC = "Enter patronymic:";
    public static final String ENTER_SKYPE = "Enter Skype address:";
    public static final String ENTER_EMAIL = "Enter email address:";
    public static final String ENTER_NICKNAME = "Enter nickname (from 2 to 20 symbols, starts with letter):";
    public static final String ENTER_GROUPS = "Enter groups (Can be friends, colleagues or relatives. " +
            "If there are more than one group, separate it by whitespace):";
    public static final String ENTER_PHONE = "Enter phone (in format +XX (XXX) XXX-XX-XX):";
    public static final String ENTER_MOBILE_PHONE = "Enter mobile phone (in format +XX (XXX) XXX-XX-XX):";
    public static final String ENTER_ANOTHER_MOBILE_PHONE = "Enter additional mobile phone " +
            "(this field is not required):";
    public static final String ENTER_INDEX = "Enter index:";
    public static final String ENTER_CITY = "Enter city:";
    public static final String ENTER_STREET = "Enter street:";
    public static final String ENTER_HOUSE_NUMBER = "Enter house number:";
    public static final String ENTER_FLAT_NUMBER = "Enter flat number:";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please!";
    public static final String ENTER_COMMENT = "Enter comment:";

    /**
     * Prints message in console
     * @param message text message
     */
    public void printMessage(String message){
        System.out.println(message);
    }


}
