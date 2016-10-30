package ua.kpi.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class represents controller in MVC pattern
 *
 * @author Yurii Krat
 * @version 1.0, 30.10.2016
 */
public class Controller {

    /**
     * Minimal value of a range
     */
    private static final int MIN_VALUE = 0;

    /**
     * Maximal value of a range
     */
    private static final int MAX_VALUE = 100;

    /**
     * The model in MVC pattern
     */
    private Model model;

    /**
     * The view in MVC pattern
     */
    private View view;

    /**
     * Initializes fields {@link #model}, {@link #view}
     * @param model model in MVC pattern
     * @param view view in MVC pattern
     */
    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Represents the act of playing game
     */
    public void playGame(){
        model.setMinValue(MIN_VALUE);
        model.setMaxValue(MAX_VALUE);
        model.setComputerValue((int)(Math.random() * 100));
        int userValue = -1;
        boolean correct = false;
        view.printMessage(View.WELCOME_STRING);
        do {
            view.printMessageAndTwoInts(View.ENTER_NUMBER, model.getMinValue(), model.getMaxValue());
            while(!correct) {
                try {
                    userValue = getInputValue();
                    correct = true;
                } catch (NumberFormatException | IOException e) {
                    e.printStackTrace();
                }
            }
            if (userValue > model.getComputerValue()) {
                model.setMaxValue(userValue);
                view.printMessage(View.MORE_THAN);
            } else if (userValue < model.getComputerValue()) {
                model.setMinValue(userValue);
                view.printMessage(View.LESS_THAN);
            }
            model.getUserValues().add(userValue);
        } while(userValue != model.getComputerValue());
        view.printMessage(View.VICTORY);
        view.printAttempts(model.getUserValues());
    }

    /**
     * Read integer value entered by user
     * @return user's entered value
     */
    public int getInputValue() throws IOException, NumberFormatException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(bufferedReader.readLine());
        if (inputNumber > model.getMaxValue() || inputNumber < model.getMinValue()) {
            throw new IOException();
        }
        return inputNumber;
    }
}
