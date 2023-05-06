package domain;

public class Person {
    private String name;
    private String mood;//estado de animo
    public String priority; //1=low, 2=medium, 3=high


    public Person(String name, String mood) {
        this.name = name;
        this.mood = mood;
    }

    public Person(String name, String mood, String priority) {
        this.name = name;
        this.mood = mood;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}
