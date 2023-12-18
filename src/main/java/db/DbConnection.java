package db;
import models.Student;
import java.sql.*;
import java.util.ArrayList;

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
            ex.printStackTrace();
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            ResultSet result = this.stmt.executeQuery("SELECT * FROM etudiants");
            while (result.next()) {
                int id = result.getInt("id");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String filiere = result.getString("filiere");
                int age = result.getInt("age");
                double moyenne = result.getDouble("moyenne");
                Student student = new Student(id, nom, prenom, filiere, age, moyenne);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return students;
    }


    public void addStudent(Student student) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO etudiants (nom, prenom, filiere, age, moyenne) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, student.getNom());
            statement.setString(2, student.getPrenom());
            statement.setString(3, student.getFiliere());
            statement.setInt(4, student.getAge());
            statement.setDouble(5, student.getMoyenne());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("DELETE FROM etudiants WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudent(int id) {
        Student student = null;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT * FROM etudiants WHERE id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String filiere = result.getString("filiere");
                int age = result.getInt("age");
                double moyenne = result.getDouble("moyenne");
                student = new Student(id, nom, prenom, filiere, age, moyenne);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

}
