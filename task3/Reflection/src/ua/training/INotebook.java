package ua.training;

import java.time.LocalDate;


/**
 * @author Yurii Krat
 * @version 1.0, 08.11.16
 */
public interface INotebook {

    String getFirstName();
    String getLastName();
    String getPhone();
    LocalDate getBirthday();
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setPhone(String phone);
    void setBirthday(LocalDate birthday);

}
