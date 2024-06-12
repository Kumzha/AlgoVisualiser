
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class Display {

    private JFrame frame;
    private SortArray sortArray;
    public static JTextField textField;

    public Display(){

        SwingUtilities.invokeLater(() -> {

            frame = new JFrame("Algorythm Visualiser");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.validate();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setLayout(new FlowLayout());

            sortArray = new SortArray();
            UI UI = new UI(sortArray);

            frame.add(UI);
            // frame.add(sortArray);

            textField = new JTextField("Console");
            textField.setSize(1000,250);
            textField.setEditable(false);
            textField.setHorizontalAlignment(JTextField.CENTER);

            JPanel consoleAndDisplay = new JPanel();
            consoleAndDisplay.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT+250);
            consoleAndDisplay.setLayout(new BoxLayout(consoleAndDisplay, BoxLayout.Y_AXIS));
            consoleAndDisplay.add(sortArray);
            consoleAndDisplay.add(textField);

            frame.add(consoleAndDisplay);
   
            frame.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT+250);
            frame.pack();
            frame.setLocationRelativeTo(null);

        });
        
    }

    public static void main(String[] args) throws Exception {
        
        
        @SuppressWarnings("unused")
        Display display = new Display();

        
    }
   

}
