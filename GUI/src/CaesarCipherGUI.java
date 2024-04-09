import javax.swing.*;
import java.awt.*;

public class CaesarCipherGUI extends JFrame {
    public  CaesarCipherGUI()
    {
        super("Caesar's Cipher Application"); //setting the frame title
        initializeGUI();
    }

    private void initializeGUI()
    {
        //Setting the size
        setSize(1000,800);
        //Setting the layout
        setLayout(new BorderLayout(5, 10));

        // South panel
        JPanel southPanel     = new JPanel(); //this is what will use the borderlayout
        JLabel messageToInput = new JLabel("Type here: ");
        JTextField userInput  = new JTextField(20); // this is where the user can actually input something
        //Encrypt and Decrypt buttons - In South Panel
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        JButton exitButton = new JButton("Exit");
        // Adding the Components to the South Panel
        southPanel.add(messageToInput);
        southPanel.add(userInput);
        southPanel.add(addButton);
        southPanel.add(deleteButton);
        southPanel.add(encryptButton);
        southPanel.add(decryptButton);
        southPanel.add(exitButton);
        //Then adding the southPanel to the South Region
        add(southPanel, BorderLayout.SOUTH);



        // Center Panel
        JTextArea textDisplay = new JTextArea(10,2);
        textDisplay.setEditable(false); // this is so it cannot be edited
        JScrollPane scrollBar = new JScrollPane(textDisplay); // adding the scroll bar functionality
        add(scrollBar, BorderLayout.CENTER);

        pack(); // helps make it look nice
        setLocationRelativeTo(null); //cool way to make sure the application opens in the middle of the screen
        //This is to make the application visible
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes progra

    }
}
