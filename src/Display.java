
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Display {

    private JFrame frame;
    private SortArray sortArray;

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
            frame.add(sortArray);
   
            frame.setSize(SortArray.WIN_WIDTH, SortArray.WIN_HEIGHT);
            frame.pack();
            frame.setLocationRelativeTo(null);

        });
        
    }

    public static void main(String[] args) throws Exception {
        
        
        @SuppressWarnings("unused")
        Display display = new Display();

        
    }
   

}
