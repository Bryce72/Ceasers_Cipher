import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaesarCipherGUI extends JFrame {

    private JPanel      southPanel;
    private JLabel      messageToInput;
    private JTextField  userInput;
    private JButton     addButton;
    private JButton     deleteButton;
    private JButton     encrypt;
    private JButton     decrypt;
    private JButton     exitButton;
    private JList       textDisplay;
    private JScrollPane scrollBar;

    private DefaultListModel words;

    public  CaesarCipherGUI()
    {
        super("Caesar's Cipher Application"); //setting the frame title
        initializeGUI();


    }

    private void initializeGUI()
    {
        words = new DefaultListModel();
        //Setting the size
        setSize(1000,800);
        //Setting the layout
        setLayout(new BorderLayout(5, 10));

        // South panel
        southPanel     = new JPanel(); //this is what will use the borderlayout
        messageToInput = new JLabel("Type here: ");
        userInput  = new JTextField(20); // this is where the user can actually input something
        //Encrypt and Decrypt buttons - In South Panel
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");
        exitButton = new JButton("Exit");

        // Adding the Components to the South Panel
        southPanel.add(messageToInput);
        southPanel.add(userInput);
        southPanel.add(addButton);
        southPanel.add(deleteButton);
        southPanel.add(encrypt);
        southPanel.add(decrypt);
        southPanel.add(exitButton);
        //Then adding the southPanel to the South Region
        add(southPanel, BorderLayout.SOUTH);



        // Center Panel
        textDisplay = new JList();
        //textDisplay.setEditable(false); // this is so it cannot be edited
        scrollBar = new JScrollPane(textDisplay); // adding the scroll bar functionality
        add(scrollBar, BorderLayout.CENTER);

        pack(); // helps make it look nice
        setLocationRelativeTo(null); //cool way to make sure the application opens in the middle of the screen
        //This is to make the application visible
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes progra


        addButton.addActionListener(AddItemAction());
        exitButton.addActionListener(CloseAction());

        textDisplay.setModel(words);

    }

    public ActionListener AddItemAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(userInput.getText().length()>0)
                {
                    words.addElement(userInput.getText());
                    textDisplay.setModel(words);
                }

                userInput.setText("");
            }
        };
    }

    public ActionListener CloseAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        };
    }
}