import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import java.util.*;


public class SortArray extends JPanel {

    public static final int WIN_WIDTH = 1000;
    public static final int WIN_HEIGHT = WIN_WIDTH * 9 / 16 ; // 562

    public static int size = 500;
    private static float increment = (float) WIN_HEIGHT / size;
    private static float barWidth = (float) WIN_WIDTH / size;

    public float[] array = new float[size];

    public static boolean sorting = false;
    public static boolean shuffling = false;

    public SwingWorker<Void,Void> sorter,shuffler;

    public String algoType = "Bubble Sort";

    int currentIndex = 0;
    int iterator = 0;
    
    public SortArray() {

        setBackground(Color.BLACK);
       
        setSize(WIDTH, HEIGHT);

        fillArray(array);
        
        shuffleArray(array);
    }

    public void sorter(float[] array, SortArray sortArray, String algorythm) {
        
        sorter = new SwingWorker<>() {

            @Override
            protected Void doInBackground() throws InterruptedException {

                currentIndex = 0;
                iterator = 0;

                sorting = true;

                SortAlgorythm.runAlgorythm(algorythm, sortArray);

                repaint();
                sorting = false;
                return null;
            }
            
        };

        if(sorting != true){
            sorter.execute();
        }
    }

    public void fillArray(float[] array){

        for (int i = 0; i < size; i++) {
            
            array[i] = i * increment;
        }
    }

    public void shuffleArray(float[] array) {

        shuffler = new SwingWorker<>() {
        @Override
        protected Void doInBackground() throws Exception {

            currentIndex = 0;
            iterator = 0;

            if(sorting==true||shuffling==true){
                return null;
            }
            shuffling = true;
            
            Random rand = new Random();
    
                for (int i = 0; i < size; i++) {
                    int randomIndexToSwap = rand.nextInt(size);
                    swap(i,randomIndexToSwap);
                }
        
    
            shuffling = false;
            return null;
        }
        @Override
            protected void done() {
                super.done();
                currentIndex = 0;
                iterator = 0;
                repaint();
            }

    };

    shuffler.execute();
    
    }



    public void swap(int indexA, int indexB) throws InterruptedException {
        float temp = array[indexA];

        array[indexA] = array[indexB];
        array[indexB] = temp;

        Thread.sleep(1);
        repaint();

    }


    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        Rectangle2D.Float rect;
        

            for(int i = 0; i < size; i++){

                g2d.setColor(Color.WHITE);

                
                float height = array[i];
                float beginX = i * barWidth;
                float beginY = WIN_HEIGHT - height;

                rect = new Rectangle2D.Float(beginX, beginY, barWidth, height);
                
                
                g2d.fill(rect);

            } 

            rect = new Rectangle2D.Float(currentIndex * barWidth, WIN_HEIGHT - array[currentIndex], barWidth, array[currentIndex]);
            g2d.setColor(Color.RED);
            g2d.fill(rect);

            rect = new Rectangle2D.Float(iterator * barWidth, WIN_HEIGHT - array[iterator], barWidth, array[iterator]);
            g2d.setColor(Color.GREEN);
            g2d.fill(rect);


    }

    //----------------------------------------------------------
    //-----------------Getters/Setters--------------------------

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }


    public int getArraysize() {
        return size;
    }

    public void setArraySize(int size) throws InterruptedException {

        SortArray.size = size;
        SortArray.increment = (float) WIN_HEIGHT / size;
        SortArray.barWidth = (float) WIN_WIDTH / size;
        array = new float[size];
        fillArray(array);
        shuffleArray(array);

    }

    public void setAlgorythmType(String algoType) {
        this.algoType = algoType;
    }


}
