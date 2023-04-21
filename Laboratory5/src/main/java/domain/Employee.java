package domain;

import util.Utility;

import java.time.LocalDate;
import java.time.Period;
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


        return null;
    }// hacer

    @Override
    public String toString() {
        String result;
        result = "(ID)" + id +
                "/(Name)" + lastName + "," + firstName +
                "/(Birthday)" + util.Utility.dateFormat(birthday) +
                "/(Title)" + title +
                "/(Age))" + getAge(birthday);
        return result;
    }
}
