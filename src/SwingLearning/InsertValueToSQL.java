// Java Program to create a simple JTextArea

import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

class InsertValueToSQL extends JFrame implements ActionListener {

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;

    // text area
    static JTextArea jt;

    // default constructor
    InsertValueToSQL() {
    }

    // main class
    public static void main(String[] args) {
        // create a new frame to store text field and button
        f = new JFrame("textfield");

        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        InsertValueToSQL te = new InsertValueToSQL();

        // addActionListener to button
        b.addActionListener(te);

        // create a text area, specifying the rows and columns
        jt = new JTextArea(10, 10);

        JPanel p = new JPanel();

        // add the text area and button to panel
        p.add(jt);
        p.add(b);
        p.add(l);

        f.add(p);
        // set the size of frame
        f.setSize(300, 300);

        f.setVisible(true);
    }

    // if the button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            String str = jt.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");

                try (Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test1", "root", "password")) {

                    Statement stmt = (Statement) con.createStatement();

                    String name = str;

                    String insert = "INSERT INTO table2 VALUES('" + name + "')";
                    stmt.executeUpdate(insert);
                }
            } catch (ClassNotFoundException | SQLException e1) {
                System.out.println(e1);
            }
            System.out.println(str);
            f.dispose();
        }
    }
}
