import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.kpi.training.Controller;
import ua.kpi.training.Record;
import ua.kpi.training.View;

/**
 * @author Yurii Krat
 * @version 1.0, 06.11.16
 */
public class TestController {

    private Controller controller;
    private Record model;
    private View view;

    @Before
    public void initializeMVC() {
        model = new Record();
        view = new View();
        controller = new Controller(model, view);
    }


    /**
     * Tests email address input
     */
    @Test
    public void testEmailAddress() {
        Assert.assertTrue(model.validate("address@email.com", Controller.EMAIL_REGEX));
        Assert.assertFalse(model.validate("address@email", Controller.EMAIL_REGEX));
    }

    /**
     * Tests phone number input
     */
    @Test
    public void testPhone() {
        Assert.assertTrue(model.validate("+38 (044) 555-55-55", Controller.PHONE_REGEX));
        Assert.assertFalse(model.validate("+38 044 555 55 55", Controller.EMAIL_REGEX));
    }

    /**
     * Tests name input
     */
    @Test
    public void testName() {
        Assert.assertTrue(model.validate("Yurii", Controller.NAME_REGEX));
        Assert.assertFalse(model.validate("Yurii97", Controller.EMAIL_REGEX));
    }

    /**
     * Tests groups input
     */
    @Test
    public void testGroups() {
        Assert.assertTrue(model.validate("friends relatives", Controller.GROUPS_REGEX));
        Assert.assertFalse(model.validate("Friend", Controller.EMAIL_REGEX));
    }

}
