package sort_visualizer;


import sort_visualizer.sorts.BubbleSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sort_visualizer.UtilityClass.addAButton;
import static sort_visualizer.UtilityClass.addATextField;


public class Menu {
    private static JFrame frame;
    final static String SORTSPANEL = "Sorting Algorithm";
    final static String INPUTPANEL = "ArrayInput";

    public void addComponentsToPane(Container pane){
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();

        tabbedPane.addTab(SORTSPANEL, card1);
        JTextField elemNr = addATextField("Number of Elements:",100,card2);
        JTextField minVal =addATextField("Minimum value of element",-480,card2);
        JTextField maxVal = addATextField("Maximum value of element",480,card2);

        addAButton("Bubble Sort", card1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BubbleSort b1=new BubbleSort(Integer.parseInt(elemNr.getText()),
                            Integer.parseInt(minVal.getText()),
                            Integer.parseInt(maxVal.getText()));
                    b1.sort();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                frame.dispose();
            }
        });

        tabbedPane.addTab(INPUTPANEL, card2);

        // tre sa schimbi linia asta
        pane.add(tabbedPane, BorderLayout.CENTER);
    }


    public static void createAndShowGUI(){
        frame = new JFrame("Sorting Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu arrayInputMenu = new Menu();
        arrayInputMenu.addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

}

