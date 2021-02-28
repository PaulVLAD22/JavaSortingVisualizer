package sort_visualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class QuickSort extends JPanel {
    int[] array;
    int frameWidth = 800;

    public static void main(String[] args) {
        //index
        int elemNr = 100, minVal = 100, maxVal = 400;

        JFrame a = new JFrame();
        QuickSort b = new QuickSort();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(900, 600);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        a.add(b);
        b.array = generateArray(elemNr, minVal, maxVal);

        int[] array = b.array;

        b.sort(array, 0, array.length - 1);
    }

    private static int[] generateArray(int elemNr, int minVal, int maxVal) {
        Random rand = new Random();
        int[] arr = new int[elemNr];
        for (int i = 0; i < elemNr; i++) {
            arr[i] = rand.nextInt(maxVal - minVal) + minVal;
        }
        return arr;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 900, 600);
        double elementWidth = (double) frameWidth / array.length;
        g.setColor(Color.white);
        for (int i = 0; i < array.length; i++) {
            g.drawRect(40 + (int) Math.floor(elementWidth * (i)), 500 - array[i], (int) Math.floor(elementWidth), array[i]);
            //g.fillRect((int)Math.floor(elementWidth*(i)),600-array[i],(int)Math.floor(elementWidth),array[i]);
        }
    }

    public void swap(int arr[], int i, int j) {
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
    }

    public void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            //sorting the smaller elements and the bigger
            sort(arr, begin, partitionIndex - 1);
            try {
                Thread.sleep(20);
                this.repaint();
            } catch (Exception e) {

            }
            sort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        //choosing the pivot as the last element
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                try {
                    Thread.sleep(20);
                    this.repaint();
                } catch (Exception e) {

                }
                //placing the smaller elements at the start of the array
                swap(arr, i, j);
            }
        }
        //placing the pivot before the first element with higher value
        swap(arr, i + 1, end);
        return i + 1;
    }


}
