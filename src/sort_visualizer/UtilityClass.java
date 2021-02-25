package sort_visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class UtilityClass {
    public static void addAButton(String text, Container container, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setPreferredSize(new Dimension(100,30));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
    public static void addALabel(String text, Container container) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(200,30));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }
    public static JTextField addATextField(String text,Integer baseValue, Container container){
        addALabel(text,container);

        JTextField textField = new JTextField();
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("SansSerif",Font.CENTER_BASELINE,16));
        textField.setPreferredSize(new Dimension(100,30));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setText(baseValue.toString());
        container.add(textField);

        return textField;
    }
    public static int [] generateArray(int elemNr, int minVal, int maxVal){
        Random rand = new Random();
        int [] arr = new int [elemNr];
        for (int i=0;i<elemNr;i++){
            arr[i]=rand.nextInt(maxVal-minVal)+minVal;
        }
        return arr;
    }
}
