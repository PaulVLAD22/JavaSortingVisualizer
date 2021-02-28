package sort_visualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BubbleSort extends JPanel {
    int selected=0;
    int [] array;
    int frameWidth=800;

    public static void main(String [] args){
        //index
        int elemNr=100,minVal=0, maxVal=500;

        JFrame a = new JFrame();
        BubbleSort b = new BubbleSort();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(900, 600);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.add(b);
        b.array = generateArray(elemNr,minVal,maxVal);

        b.sort();
    }

    private static int[] generateArray(int elemNr, int minVal, int maxVal) {
        Random rand = new Random();
        int [] arr = new int [elemNr];
        for (int i=0;i<elemNr;i++){
            arr[i]=rand.nextInt(maxVal-minVal)+minVal;
            System.out.println(arr[i]);
        }
        return arr;
    }

    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,900,600);
        double elementWidth = (double)frameWidth/array.length;
        for (int i=0;i<array.length;i++){
            if (selected==i)
                g.setColor(Color.red);
            else
                g.setColor(Color.white);
            g.drawRect(40+(int)Math.floor(elementWidth*(i)),500-array[i],(int)Math.floor(elementWidth),array[i]);
            //g.fillRect((int)Math.floor(elementWidth*(i)),600-array[i],(int)Math.floor(elementWidth),array[i]);
        }
    }
    public void sort(){
        try{
            Thread.sleep(100);
            this.repaint();
        }catch(Exception e){

        }
        for (int i=0;i<array.length-1;i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    selected=j;
                    int c =array[i];
                    array[i]= array[j];
                    array[j]=c;
                    try{
                        Thread.sleep(10);
                        this.repaint();
                    }catch(Exception e){

                    }
                }
            }
        }
    }


}