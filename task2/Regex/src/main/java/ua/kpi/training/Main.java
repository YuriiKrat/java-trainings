package ua.kpi.training;

public class Main {

    public static void main(String[] args) {

        // Initialization
        Record model = new Record();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.enterData();
    }

}
