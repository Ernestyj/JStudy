package eugene.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DCLab on 2016/11/6.
 */
public class HelloSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello");
        JLabel label = new JLabel("Hi");
        JButton b1 = new JButton("B1"), b2 = new JButton("B2");
        JTextField textField = new JTextField(20);

        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(b1);
        frame.add(b2);
        frame.add(textField);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(((JButton)e.getSource()).getText());
            }
        });

        SwingConsole.run(frame, 500, 500);
    }

}
