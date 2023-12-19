package db;

import models.Student;

import java.sql.*;
import java.util.ArrayList;

import models.User;

public class DbConnection {

    Statement stmt = null;
    Connection conn = null;

    public DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moha?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "moha");
            Statement statement = connection.createStatement();
            this.stmt = statement;
            this.conn = connection;
            System.out.println("Connected successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("an error occured while connecting to the database");
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            ResultSet result = this.stmt.executeQuery("SELECT * FROM students");
            while (result.next()) {
                int id = result.getInt("id");
                String lastName = result.getString("lastName");
                String firstName = result.getString("firstName");
                String major = result.getString("major");
                int age = result.getInt("age");
                double average = result.getDouble("average");
                Student student = new Student(id, lastName, firstName, major, age, average);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }

    // students operations
    public void addStudent(Student student) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO students (firstName, lastName, major, age, average) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getMajor());
            statement.setInt(4, student.getAge());
            statement.setDouble(5, student.getAverage());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("DELETE FROM students WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(int id) {
        Student student = null;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String lastName = result.getString("lastName");
                String firstName = result.getString("firstName");
                String major = result.getString("major");
                int age = result.getInt("age");
                double average = result.getDouble("average");
                student = new Student(id, lastName, firstName, major, age, average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    // user operations
    public User checkUser(String email, String password) {
        User user = null;
        try {
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            try (PreparedStatement statement = this.conn.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, password);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        int id = result.getInt("id");
                        String resEmail = result.getString("email");
                        String resPassword = result.getString("password");
                        user = new User(id, resEmail, resPassword);
                        return user;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred");
            ex.printStackTrace(); // Print the stack trace for debugging
        }
        return user;
    }

}
