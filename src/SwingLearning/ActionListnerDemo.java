/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.awt.event.*;
import javax.swing.*;
public class ActionListnerDemo {
    
    public static void main(String args[]){
        
        JFrame f = new JFrame("Frame");
        f.setSize(400, 300);
        
        JButton b= new JButton("click here to display text ");
        b.setBounds(80,200,300,40);
        f.add(b);
         f.setLayout(null);
        
        final JTextField tf =new JTextField();
        tf.setBounds(100, 50, 200, 20);
        f.add(tf);
        
        b.addActionListener((ActionEvent e) -> {
            
            tf.setText("You clicked the button");
        });
        
        
        
        f.setVisible(true);
    }
}
