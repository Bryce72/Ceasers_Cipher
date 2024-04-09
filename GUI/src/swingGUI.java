import javax.swing.*;
import java.awt.*;

public class swingGUI {
    public static void main(String[] args) {
        //Creating the frame for the GUI
        JFrame f = new JFrame("Ceasar's Cipher Application");

        //Setting the size
        f.setSize(1000,800);

        //Setting the layout
        f.setLayout(new BorderLayout(5, 10));

        //This is going to be where the user can input the message they want to encrypt - In South Panel
        JPanel southPanel = new JPanel(); //this is what will use the borderlayout
        JLabel messageToInput = new JLabel("Type here to Encrypt or Decrypt a message: ");
        f.add(messageToInput); // adding the userinput LABEL to the frame
        JTextField userInput = new JTextField(20); // this is where the user can actually input something


        //Encrypt and Decrypt buttons - In South Panel
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");

        // Adding the Components to the South Panel
        southPanel.add(messageToInput);
        southPanel.add(userInput);
        southPanel.add(encryptButton);
        southPanel.add(decryptButton);
        //Then adding the southPanel to the South Region
        f.add(southPanel, BorderLayout.SOUTH);




        //The text area that will display what the user inputs - In Center Panel
        JTextArea textDisplay = new JTextArea(10, 30);
        textDisplay.setEditable(false); // this is so it cannot be edited
        JScrollPane scrollBar = new JScrollPane(textDisplay); // adding the scroll bar functionality
        f.add(scrollBar, BorderLayout.CENTER);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes program
        f.pack(); // helps make it look nice
        f.setLocationRelativeTo(null); //cool way to make sure the application opens in the middle of the screen
        //This is to make the application visible
        f.setVisible(true);

    }

}
