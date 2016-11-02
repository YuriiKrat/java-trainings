import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.kpi.training.Controller;
import ua.kpi.training.Model;
import ua.kpi.training.View;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Yurii Krat
 * @version 1.0, 30.10.16
 */
public class TestController {

    private Controller controller;
    private Model model;
    private View view;

    private final static int MAX_VALUE = 100;
    private final static int MIN_VALUE = 0;

    @Before
    public void initializeMVC() {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);
        model.setLimits(MIN_VALUE, MAX_VALUE);
    }

    /**
     * Tests handling exceptions with wrong type input
     * @throws IOException
     */
    @Test(expected = NumberFormatException.class)
    public void testInvalidTypeInput() throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream("Any string without numbers".getBytes());
        System.setIn(in);
        controller.getInputValue();
    }

    /**
     * Tests end of the game by victory
     * @throws IOException
     */
    @Test
    public void testVictory() throws IOException{
        ByteArrayInputStream in = new ByteArrayInputStream(Integer.toString(MAX_VALUE - 1).getBytes());
        System.setIn(in);
        model.setComputerValue(MAX_VALUE - 1);
        Assert.assertEquals(model.getComputerValue(), controller.getInputValue());
    }

    /**
     * Tests if computer value is in a range
     */
    @Test
    public void testComputerValueRange() {
        for (int i = 0; i < 1000 ; i++) {
            model.setComputerValue();
            Assert.assertTrue(model.checkRange(model.getComputerValue()));
        }
    }
}
