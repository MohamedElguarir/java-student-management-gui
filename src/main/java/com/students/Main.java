package com.students;
import javax.swing.JFrame;
import ui.Dashboard;
import ui.Login;

public class Main {
    public static JFrame login = new Login();
    public static JFrame dashboard = new Dashboard();

    public static void main(String[] args) {
        login.setLocationRelativeTo((null));
        dashboard.setLocationRelativeTo((null));
        login.setVisible(true);
    }
}
