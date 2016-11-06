package eugene.gui.swing;

import javax.swing.*;

/**
 * Created by DCLab on 2016/11/6.
 */
public class SwingConsole {
    public static void run(JFrame f, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }
}
