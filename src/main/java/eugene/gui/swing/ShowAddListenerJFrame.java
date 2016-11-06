package eugene.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DCLab on 2016/11/6.
 */
public class ShowAddListenerJFrame extends JFrame {
    private JTextField nameTF = new JTextField(25);
    private JTextArea resultsTA = new JTextArea(40, 65);

    private static Pattern addListenerP = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
    private static Pattern qualifierP = Pattern.compile("\\w+\\.");

    public ShowAddListenerJFrame(){
        NameListener nameListener = new NameListener();
        nameTF.addActionListener(nameListener);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Swing class name (press enter)"));
        topPanel.add(nameTF);
        this.add(BorderLayout.NORTH, topPanel);
        this.add(new JScrollPane(resultsTA));

        nameTF.setText("JTextArea");
        nameListener.actionPerformed(new ActionEvent("", 0, ""));
    }

    class NameListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameTF.getText().trim();
            if (name.length()==0){
                resultsTA.setText("No match.");
                return;
            }
            Class<?> kind;
            try{
                kind = Class.forName("javax.swing."+name);
            } catch (ClassNotFoundException e1) {
                resultsTA.setText("No match.");
                return;
            }
            Method[] methods = kind.getMethods();
            resultsTA.setText("");
            for (Method m: methods){
                Matcher matcher = addListenerP.matcher(m.toString());
                if (matcher.find())
                    resultsTA.append(qualifierP.matcher(matcher.group(1)).replaceAll("")+"\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowAddListenerJFrame(), 500, 400);
    }
}
