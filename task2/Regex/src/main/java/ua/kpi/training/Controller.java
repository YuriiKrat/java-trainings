package ua.kpi.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class represents controller in MVC pattern
 *
 * @author Yurii Krat
 * @version 1.0, 06.11.2016
 */
public class Controller {

    /**
     * The model in MVC pattern
     */
    private Record record;

    /**
     * The view in MVC pattern
     */
    private View view;

    // Constants
    public final static String EMAIL_REGEX = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
    public final static String PHONE_REGEX = "\\+[0-9]{2}\\s\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{2}-[0-9]{2}";
    public final static String ADDITIONAL_PHONE_REGEX = "\\+[0-9]{2}\\s\\([0-9]{3}\\)" +
            "\\s[0-9]{3}-[0-9]{2}-[0-9]{2}|^$";
    public final static String NICKNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    public final static String NAME_REGEX = "^[A-Z][a-zA-Z]+$";
    public final static String INDEX_REGEX = "[0-9]{5}";
    public final static String FLAT_NUMBER_REGEX = "[1-9][0-9]*";
    public final static String HOUSE_NUMBER_REGEX = "[1-9][0-9]*[a-z]?";
    public final static String COMMENT_REGEX = "^[a-zA-Z0-9\\s]+$";
    public final static String GROUPS_REGEX = "((friends|colleagues|relatives)(\\s|$)){1,3}";

    /**
     * Initializes fields {@link #record}, {@link #view}
     * @param record model in MVC pattern
     * @param view view in MVC pattern
     */
    public Controller(Record record, View view) {
        this.record  = record;
        this.view = view;
    }

    /**
     * Adds user input data to the record
     */
    public void enterData() {
        try {
            Address address = new Address();
            String inputValue;
            inputValue = enterValue(View.ENTER_LAST_NAME, NAME_REGEX);
            record.setLastName(inputValue);
            inputValue = enterValue(View.ENTER_FIRST_NAME, NAME_REGEX);
            record.setFirstName(inputValue);
            record.setName();
            inputValue = enterValue(View.ENTER_PATRONYMIC, NAME_REGEX);
            record.setPatronymic(inputValue);
            inputValue = enterValue(View.ENTER_NICKNAME, NICKNAME_REGEX);
            record.setNickname(inputValue);
            inputValue = enterValue(View.ENTER_EMAIL, EMAIL_REGEX);
            record.setEmail(inputValue);
            inputValue = enterValue(View.ENTER_PHONE, PHONE_REGEX);
            record.setHomePhone(inputValue);
            inputValue = enterValue(View.ENTER_MOBILE_PHONE, PHONE_REGEX);
            record.setMobilePhone(inputValue);
            inputValue = enterValue(View.ENTER_ANOTHER_MOBILE_PHONE, ADDITIONAL_PHONE_REGEX);
            record.setMobilePhone2(inputValue);
            inputValue = enterValue(View.ENTER_GROUPS, GROUPS_REGEX);
            record.setGroups(inputValue);
            inputValue = enterValue(View.ENTER_SKYPE, NICKNAME_REGEX);
            record.setSkype(inputValue);
            inputValue = enterValue(View.ENTER_COMMENT, COMMENT_REGEX);
            record.setComment(inputValue);
            inputValue = enterValue(View.ENTER_INDEX, INDEX_REGEX);
            address.setIndex(Integer.parseInt(inputValue));
            inputValue = enterValue(View.ENTER_CITY, NAME_REGEX);
            address.setCity(inputValue);
            inputValue = enterValue(View.ENTER_STREET, NAME_REGEX);
            address.setStreet(inputValue);
            inputValue = enterValue(View.ENTER_HOUSE_NUMBER, HOUSE_NUMBER_REGEX);
            address.setHouseNumber(inputValue);
            inputValue = enterValue(View.ENTER_FLAT_NUMBER, FLAT_NUMBER_REGEX);
            address.setFlatNumber(Integer.parseInt(inputValue));
            record.setAddress(address);
            record.setFullAddress();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns value input by user
     *
     * @param message message to be displayed
     * @param regex regular expression
     * @return input value
     * @throws IOException
     */
    private String enterValue(String message, String regex) throws IOException {
        view.printMessage(message);
        String input = getStringInputValue();
        while (!record.validate(input, regex)) {
            view.printMessage(View.WRONG_INPUT_DATA);
            view.printMessage(message);
            input = getStringInputValue();
        }
        return input;
    }

    /**
     * Read string value entered by user
     * @return user's entered value
     */
    public String getStringInputValue() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

}
