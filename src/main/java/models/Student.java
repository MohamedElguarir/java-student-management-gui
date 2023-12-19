package models;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String major;
    private int age;
    private double average;

    public Student(int id, String lastName, String firstName, String major, int age, double average) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.major = major;
        this.age = age;
        this.average = average;
    }

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        String st = "-ID: " + this.id + "\n";
        st += "-First name: " + this.firstName + "\n";
        st += "-Last name: " + this.lastName + "\n";
        st += "-Major: " + this.major + "\n";
        st += "-Age: " + this.age + "\n";
        st += "-Average: " + this.average + "\n";
        return st;
    }

}
