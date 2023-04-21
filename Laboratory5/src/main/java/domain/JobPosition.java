package domain;

public class JobPosition {
    private int  id;
    private String description;
    private Double hourlyWage;
    private static int autoId;// id autogenerado

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public JobPosition(String description, double hourlyWage) {
        this.description=description;
        this.hourlyWage=hourlyWage;
        this.id = ++autoId;
    }
    public JobPosition(String description) {
        this.description=description;
    }

    public double getSalary(double n) {
        return n*this.hourlyWage;
    }

    @Override
    public String toString() {
        String result;

       result = "(ID)" + id +
                "/(Job Position)" + description+
                "/(Hourly Wage)" +hourlyWage;
       return result;
    }
}
