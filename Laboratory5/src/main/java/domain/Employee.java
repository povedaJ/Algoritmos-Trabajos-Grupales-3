package domain;

import util.Utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Employee {
    private Integer id;
    private String lastName;
    private String firstName;
    private String title;
    private Date birthday;

    public Employee(Integer id, String lastName, String firstName, String title, Date birthday) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.birthday = birthday;//fecha de nacimiento
    }

    public Integer getAge(Date date) {
        //Los meses del Date son del 0 al 11
        Date currentDate = new Date();
        currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Fecha Actual
        if ((date.getMonth() + 1) < (currentDate.getMonth() + 1)) { //verifica si el mes de cumpleaños ya paso
            return currentDate.getYear() - date.getYear();
        } else {
            if ((date.getMonth() + 1) == (currentDate.getMonth() + 1)) { // cumple el mes actual
                if (date.getDate() <= currentDate.getDate()) { // verifica si ya paso el dia de cumpleaños
                    return currentDate.getYear() - date.getYear();
                } else {
                    return currentDate.getYear() - date.getYear() - 1;
                }} else {
                return currentDate.getYear() - date.getYear() - 1;
            }}}// hacer

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String result;
        result ="\n"+"(ID)" + id +
                "/(Name)" + lastName + "," + firstName +
                "/(Birthday)" + util.Utility.dateFormat(birthday) +
                "/(Title)" + title +
                "/(Age))" + getAge(birthday);
        return result;
    }
}
