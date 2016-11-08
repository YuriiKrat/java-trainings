package ua.training;

import java.time.LocalDate;

/**
 * @author Yurii Krat
 * @version 1.0, 08.11.16
 */
public class MyDate {

    private LocalDate currentDate;

    public MyDate() {
        currentDate = LocalDate.now();
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
