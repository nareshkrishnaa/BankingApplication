/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SwingLearning;

/**
 *
 * @author Admin
 */
import javax.swing.*;

public class ImageInButton {

    public static void main(String[] args) {
        JFrame f = new JFrame("Button Example");
        JButton b = new JButton(new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\JAVA PROJECT\\images\\button_icon.png"));
        b.setBounds(100, 100, 150, 80);
        f.add(b);
        f.setSize(300, 400);
        f.setLayout(null);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
