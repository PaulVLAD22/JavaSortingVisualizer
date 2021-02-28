package sort_visualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class QuickSort extends JPanel {
    int selected=0;
    int [] array;
    int frameWidth=900;

    public static void main(String [] args){
        //index
        int elemNr=100,minVal=100, maxVal=400;

        JFrame a = new JFrame();
        QuickSort b = new QuickSort();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(900, 600);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.add(b);
        b.array = generateArray(elemNr,minVal,maxVal);

        int [] array=b.array;

        b.sort();
    }

    private static int[] generateArray(int elemNr, int minVal, int maxVal) {
        Random rand = new Random();
        int [] arr = new int [elemNr];
        for (int i=0;i<elemNr;i++){
            arr[i]=rand.nextInt(maxVal-minVal)+minVal;
        }
        return arr;
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,900,600);
        double elementWidth = (double)frameWidth/array.length;
        for (int i=0;i<array.length;i++){
            if (selected==i)
                g.setColor(Color.green);
            else
                g.setColor(Color.black);
            g.drawRect((int)Math.floor(elementWidth*(i)),600-array[i],(int)Math.floor(elementWidth),array[i]);
            g.fillRect((int)Math.floor(elementWidth*(i)),600-array[i],(int)Math.floor(elementWidth),array[i]);
        }
    }
    public void sort(){
        for (int i=0;i<array.length-1;i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    selected=j;
                    int c =array[i];
                    array[i]= array[j];
                    array[j]=c;
                    try{
                        Thread.sleep(1);
                        this.repaint();
                    }catch(Exception e){

                    }
                }
            }
        }
    }


}
