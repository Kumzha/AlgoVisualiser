import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JPanel{

    public UI(SortArray sortArray){
        
        this.setLayout(new GridLayout(0,1));
        addButtons(sortArray);

    }

    public void addButtons(SortArray sortArray){

            JButton startButton = new JButton("Start");
            startButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                sortArray.sorter(sortArray.array, sortArray, sortArray.algoType);
                }
            });

            JButton shuffleButton = new JButton("Shuffle Array");
            shuffleButton.addActionListener(e -> sortArray.shuffleArray(sortArray.array));

            JButton stopButton = new JButton("Stop Sorting");
            stopButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.sorter.cancel(true);
                    SortArray.sorting = false;
                }
            });

            JButton bubbleButton = new JButton("Bubble sort");
            bubbleButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.setAlgorythmType("Bubble Sort");
                }
            });

            JButton mergeButton = new JButton("Merge Sort");
            mergeButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.setAlgorythmType("Merge Sort");
                }
            });

            JButton selectionButton = new JButton("Selection Sort");
            selectionButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.setAlgorythmType("Selection Sort");
                }
            });

            JButton insertionButton = new JButton("Insertion Sort");
            insertionButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.setAlgorythmType("Insertion Sort");
                }
            });

            JButton cocktailButton = new JButton("Cocktail Sort");
            cocktailButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    sortArray.setAlgorythmType("Cocktail Sort");
                }
            });

            JTextField sizeTextArea = new JTextField(String.valueOf(SortArray.size));

            JButton setsizeButton = new JButton("Set Array size");
            setsizeButton.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        int size = Integer.parseInt(sizeTextArea.getText());
                        if (size<=0||size>10000) {
                            throw new Exception();
                        } 
                        if (size == SortArray.size) {
                            return;
                        }
                        
                        sortArray.setArraySize(size);

                    } catch (Exception e) {
                        sizeTextArea.setText("Error");
                    }
                
                }
            });

            this.add(startButton);
            this.add(shuffleButton);
            this.add(stopButton);
            this.add(bubbleButton);
            this.add(mergeButton);
            this.add(selectionButton);
            this.add(insertionButton);
            this.add(cocktailButton);
            this.add(sizeTextArea);
            this.add(setsizeButton);

    }

}
