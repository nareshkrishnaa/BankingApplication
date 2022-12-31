
import javax.swing.*;

public class JButtonDemo {

    public static void main(String args[]) {

        JFrame f = new JFrame("Frame");
        f.setSize(400, 300);

        JButton b = new JButton("Click here");
        b.setBounds(300, 200, 80, 40);
        f.add(b);
        f.setLayout(null);

        final JTextField tf = new JTextField();
        tf.setText("hi hello!!");
        tf.setBounds(100, 50, 200, 20);
        f.add(tf);
        f.setVisible(true);
    }

}
