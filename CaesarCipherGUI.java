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
    private JButton     searchButton;
    private JButton     exitButton;
    private JList       textDisplay;
    private JScrollPane scrollBar;

    private DefaultListModel words;

    private Listuse<String> messageList = new EmptyList<>();

    private boolean IsCleartext;

    //cool add ons
    private JLabel matrixGIF;
    private ImageIcon imageIcon;





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
        searchButton = new JButton("Search");
        exitButton = new JButton("Exit");

        // Adding the Components to the South Panel
        southPanel.add(messageToInput);
        southPanel.add(userInput);
        southPanel.add(addButton);
        southPanel.add(deleteButton);
        southPanel.add(encryptButton);
        southPanel.add(decryptButton);
        southPanel.add(searchButton);
        southPanel.add(exitButton);
        //Then adding the southPanel to the South Region
        add(southPanel, BorderLayout.SOUTH);



        // Center Panel
        textDisplay = new JList();
        //textDisplay.setEditable(false); // this is so it cannot be edited
        scrollBar = new JScrollPane(textDisplay); // adding the scroll bar functionality
        add(scrollBar, BorderLayout.CENTER);

        //for the gif
        matrixGIF = new JLabel(new ImageIcon("matrixGIF.gif"));
        matrixGIF.setVisible(false); //only want this true when encrypt is clicked intially
        getContentPane().add(matrixGIF, BorderLayout.NORTH); // all i need to do is ste visibility to true and then switch it off when done
        //Timer timer = new Timer(3000, encryptAction());


        imageIcon = new ImageIcon("cryptographyIcon.png");
        setIconImage(imageIcon.getImage());
        pack(); // helps make it look nice
        setLocationRelativeTo(null); //cool way to make sure the application opens in the middle of the screen
        //This is to make the application visible
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes program


        //Adding the buttons to the frame
        addButton.addActionListener(AddItemAction());
        encryptButton.addActionListener(encryptAction());
        decryptButton.addActionListener(decryptAction());
        searchButton.addActionListener(searchAction());
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
                    matrixGIF.setVisible(true);
                    new Timer (1000, e -> matrixGIF.setVisible(false)).start(); // funny addition
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
     * This is where my filter and fold is demonstrated.
     *
     * User has the option to type in a word and click the "Search" button. It will display how many times the word is found.
     *
     * Notice I am not really doing much with filter it self. This was implemented before fold and my original intention was to display
     * the filtered words in the text display but that turned out to be ugly and this has some use case.
     *
     *
     * What is the use case in finding out how many times a word occurs? Well it will show a pattern in the encrypted text
     * making the message more vulnerable to being decrypted by unwanted people.
     *
     *
     * ----Note if you search for "ee" and the word "leet" is present. It will count that as a word.
     * ---- meaning it searches for matched letters in sequence not specifically words itself.
     *
     * @return
     */

    public ActionListener searchAction()
    {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(messageList.getListSize() > 0)
                {
                    if(IsCleartext) {

                        CaesarsCipher encryptedMessageList = new CaesarsCipher();
                        String keyword = userInput.getText().toLowerCase();
                        Listuse<String> filteredMessageList =  messageList.filter(message -> message.toLowerCase(). contains(keyword)); //making a new linked list of the filtered
                        // just adding this here because it will go blank if you search something not found. this solves that
                        if(keyword.isEmpty() || filteredMessageList.getListSize() == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Oh no, nothing was found.");  //this was fun to make
                        }else
                        {
                            DefaultListModel filteredWords = new DefaultListModel<>();
                            filteredMessageList.forEach(filteredWords::addElement);
                            int occurrences = filteredMessageList.fold(0, (count, message) -> message.toLowerCase().contains(keyword) ? count + 1 : count);
                            JOptionPane.showMessageDialog(null, "The word " + keyword + " is found " + occurrences + " times.");
                            //textDisplay.setModel(filteredWords);
                        }

                    }else
                    {
                        JOptionPane.showMessageDialog(null, "Click on decrypt. Its too confusing searching for a word thats in its encryptions form.");  //this was fun to make
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