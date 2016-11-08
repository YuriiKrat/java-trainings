package ua.training;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Yurii Krat
 * @version 1.0, 08.11.16
 */
public class Notebook extends MyDate implements INotebook{

    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthday;

    public Notebook() {
        this("No name", "No surname", "No phone", LocalDate.of(2010, 1, 1));
    }

    public Notebook(String firstName, String lastName, String phone, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @MyAnnotation(enabled = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @MyAnnotation(enabled = false)
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @MyAnnotation
    public long daysLeftToBirthday() {
        LocalDate currentDate = getCurrentDate();
        LocalDate nextBDay = birthday.withYear(currentDate.getYear());

        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(currentDate) || nextBDay.isEqual(currentDate)) {
            nextBDay = nextBDay.plusYears(1);
        }

        return ChronoUnit.DAYS.between(currentDate, nextBDay);
    }

}
