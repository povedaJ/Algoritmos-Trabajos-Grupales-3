package domain;

import util.Utility;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        result = "(ID)" + id +
                "/(Name)" + lastName + "," + firstName +
                "/(Birthday)" + Utility.dateFormat(birthday) +
                "/(Title)" + title +
                "/(Age))" + getAge(birthday);
        return result;
    }
}
