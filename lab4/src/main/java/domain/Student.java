package domain;

public class Student implements Person{
    private String id;
    private String name;
    private int age;
    private String address;

    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    private int studyHours(){
        return age/2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Person other) {
        if(!(other instanceof Person))
            return false;
        Student s = (Student) other;
        return id.equals(s.id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age="
                + age + ", study hours="+studyHours()
                +", address="+address+'}';
    }
}
