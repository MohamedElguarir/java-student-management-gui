package models;

import java.util.Date;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private int major_id;
    private int age;
    private double average;
    private String gender;
    private String email;
    private String address;
    private String phone;
    private Date birthday;
    private Date enrollmentDate;


    public Student(int id, String lastName, String firstName, int major_id, int age, double average, String gender, String email, String address, String phone, Date birthday, Date enrollmentDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.major_id = major_id;
        this.age = age;
        this.average = average;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.birthday = birthday;
        this.enrollmentDate = enrollmentDate;
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

    public int getMajor() {
        return major_id;
    }

    public void setMajor(int major) {
        this.major_id = major;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        String st = "-ID: " + this.id + "\n";
        st += "-First name: " + this.firstName + "\n";
        st += "-Last name: " + this.lastName + "\n";
        st += "-Major: " + this.major_id + "\n";
        st += "-Age: " + this.age + "\n";
        st += "-Average: " + this.average + "\n";
        return st;
    }

}
