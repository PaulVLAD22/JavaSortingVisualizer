package sort_visualizer.sorts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import static sort_visualizer.UtilityClass.generateArray;

public class BubbleSort extends JFrame {
    int [] array;
    int frameWidth=960;
    int frameHeight=960;

    public BubbleSort(int elemNr, int minVal, int maxVal) throws InterruptedException {
        setTitle("Bubble Sort");
        setSize(frameWidth,frameHeight);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.array = generateArray(elemNr,minVal,maxVal);
    }

    public void paint(Graphics g){
        System.out.println("Paint");

        g.setColor(Color.GRAY);

        Rectangle2D.Double [] allRects = new Rectangle2D.Double [array.length];
        double elementWidth = (double)frameWidth/array.length;
        double middleAxis=frameHeight/2.0;
        for (int i=0;i<array.length;i++){
            if (array[i]>480)
                array[i]=480;
            else if (array[i]<-480)
                array[i]=-480;

            if (array[i]>0)
                allRects[i] = new Rectangle2D.Double(elementWidth*(i),middleAxis,elementWidth,array[i]);
            else{
                allRects[i] = new Rectangle2D.Double(elementWidth*(i),middleAxis-Math.abs(array[i]),elementWidth,Math.abs(array[i]));
            }
        }

        for (Rectangle2D.Double rect: allRects){
            g.drawRect((int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height);
            //g.fillRect((int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height);
        }

    }
    public void swapArray(int i, int j){
        int c =array[i];
        array[i]= array[j];
        array[j]=c;
    }
    public void sort() throws InterruptedException {
        System.out.println("A");
        for (int i=0;i<array.length-1;i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swapArray(i, j);

                }
            }
        }
    }

}
