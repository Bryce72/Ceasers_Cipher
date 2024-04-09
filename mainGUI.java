import javax.swing.*;

public class mainGUI {
    public static void main(String[] args)
    {


        // Reference to this when debugging: https://www.tutorialspoint.com/what-is-the-importance-of-swingutilities-class-in-java
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CaesarCipherGUI();
            }
        });
    }
}
