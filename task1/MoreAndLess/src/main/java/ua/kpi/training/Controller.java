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

        int userValue = 0;
        boolean victory = false;
        boolean correct = false;
        view.printMessage(View.WELCOME_STRING);
        do {
            try {
                view.printMessage(View.ENTER_MIN);
                int minValue = getInputValue();
                view.printMessage(View.ENTER_MAX);
                int maxValue = getInputValue();
                if(model.setLimits(minValue, maxValue)) {
                    correct = true;
                    model.setComputerValue();
                } else {
                    view.printMessage(View.WRONG_INPUT_DATA);
                }
            } catch (NumberFormatException | IOException e) {
                view.printMessage(View.WRONG_INPUT_DATA);
            }
        } while (!correct);

        do {
            view.printMessageAndTwoInts(View.ENTER_NUMBER, model.getMinValue(), model.getMaxValue());
            do {
                correct = true;
                try {
                    userValue = getInputValue();
                    if(model.checkRange(userValue)) {
                        correct = false;
                    } else {
                        view.printMessage(View.WRONG_INPUT_DATA_RANGE);
                    }
                } catch (NumberFormatException | IOException e) {
                    view.printMessage(View.WRONG_INPUT_DATA);
                }
            } while(correct);
            if (model.checkMoreOrLess(userValue)) {
                victory = true;
            }
            model.getUserValues().add(userValue);
        } while(!victory);
        view.printMessage(View.VICTORY);
        view.printAttempts(model.getUserValues());
    }

    /**
     * Read integer value entered by user
     * @return user's entered value
     */
    public int getInputValue() throws IOException, NumberFormatException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }

}
