import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;


public class CaesarCipherGUI extends JFrame {

    private JPanel      southPanel;
    private JLabel      messageToInput;
    private JTextField  userInput;
    private JButton     addButton;
    private JButton     deleteButton;
    private JButton     encryptButton;
    private JButton     decryptButton;
    private JButton     isMyMessageWeakButton;
    private JButton     exitButton;
    private JList       textDisplay;
    private JScrollPane scrollBar;

    private DefaultListModel words;

    private Listuse<String> messageList = new EmptyList<>();

    private boolean IsCleartext;





    public  CaesarCipherGUI()
    {
        super("Caesar's Cipher Application"); //setting the frame title
        initializeGUI();


    }

    private void initializeGUI()
    {
        IsCleartext=true;
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
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        isMyMessageWeakButton = new JButton("How Weak is My Message?");
        exitButton = new JButton("Exit");

        // Adding the Components to the South Panel
        southPanel.add(messageToInput);
        southPanel.add(userInput);
        southPanel.add(addButton);
        southPanel.add(deleteButton);
        southPanel.add(encryptButton);
        southPanel.add(decryptButton);
        southPanel.add(isMyMessageWeakButton);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes program


        //Adding the buttons to the frame
        addButton.addActionListener(AddItemAction());
        encryptButton.addActionListener(encryptAction());
        decryptButton.addActionListener(decryptAction());
        exitButton.addActionListener(CloseAction());
        deleteButton.addActionListener(DeleteItem());


        // Initially set to false until it makes sense for them to be activated.
        decryptButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }


    /**
     * This method relates to the Add Button.
     *
     * Need to click on "Add" button for this to initiate.
     *
     * Will only work if user inputs text of atleast 1 character.
     *
     * It will also add each element from the words list to the "messageList" which is the singly linked list applied.
     * @return
     */
    public ActionListener AddItemAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(userInput.getText().length()>0)
                {
                    String newValue = userInput.getText();

                    if(!IsCleartext) {
                        CaesarsCipher encryptedMessageList = new CaesarsCipher();
                        newValue = encryptedMessageList.encrypt(newValue);
                    }

                    words.insertElementAt(newValue, 0);
                    messageList = messageList.addFront(newValue); //adding it to my linked list structure too
                    textDisplay.setModel(words);

                    deleteButton.setEnabled(true);
                }

                userInput.setText("");
            }
        };
    }


    /**
     * This Deletes the item. If you look closely, you arent actually "deleting" a single item in the linked list.
     * You are simply emplying the linked list out and reassigning what is in the word list to the linked list.
     *
     * -- Also note, the for loop makes sure the correct order that words is in copys over to the new messageList
     * @return
     */
    public ActionListener DeleteItem()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultListModel listWords = (DefaultListModel) textDisplay.getModel();
                int selectedIndex = textDisplay.getSelectedIndex();
                if(selectedIndex != -1)
                {
                    listWords.remove(selectedIndex);
                    words = listWords;

                    messageList = new EmptyList<>();
                    for(int i=words.getSize()-1; i>=0; i--)
                    {
                        messageList = messageList.addFront(words.getElementAt(i).toString());
                    }
                    textDisplay.setModel(words);

                    if(words.getSize()==0)
                        deleteButton.setEnabled(false);
                    else
                        deleteButton.setEnabled(true);

                }
            }
        };
    }

    /**
     * This is the encrypt action button. Will only work when IsClearText is set to true.
     * Uses foreach method to update the encrypted message from the linkedlist to the "words" list that is displayed in the text GUI
     * @return
     */
    public ActionListener encryptAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(messageList.getListSize() > 0)
                {
                    if(IsCleartext) {
                        CaesarsCipher encryptedMessageList = new CaesarsCipher();
                        messageList = messageList.map(messageList -> encryptedMessageList.encrypt(messageList));
                        words.clear();
                        messageList.forEach(s -> words.addElement(s));

                        textDisplay.setModel(words);
                        IsCleartext = false;
                        encryptButton.setEnabled(false);

                        decryptButton.setEnabled(true);
                    }

                }


            }
        };
    }


    /**
     * This is the action method applied to the decrypt button.
     * Will only run if IsClearText is False(meaning it is in encrypted text) and if the messagelist has atleast one node.
     *
     * As with encrypt action it will clear the words list that is displayed and use the foreach method from the linkedlist to update it but
     * with the decrypted text.
     *
     * @return
     */

    public ActionListener decryptAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(messageList.getListSize() > 0)
                {
                    if(!IsCleartext) {
                        CaesarsCipher encryptedMessageList = new CaesarsCipher();
                        messageList = messageList.map(messageList -> encryptedMessageList.decrypt(messageList));
                        words.clear();
                        messageList.forEach(s -> words.addElement(s));

                        textDisplay.setModel(words);
                        IsCleartext = true;

                        encryptButton.setEnabled(true);
                        decryptButton.setEnabled(false);
                    }

                }


            }
        };
    }






    /**
     * Simple action method applied to the "Exit" button.
     *
     * Closes Program when "Exit" button is clicked.
     * @return
     */

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