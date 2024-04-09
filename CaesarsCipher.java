public class CaesarsCipher implements CryptographyWork{

    /*
    * -Implements the Caesars Cipher Encryption and Decryption-
    *
    *
    * Named after Julius Caesar this cipher is also considered, shift cipher because inorder to encrypt a message
    * using this you "shift" the letter to the left by 3. Although easy to crack in todays age, it is an awesome introduction to
    * the world of cryptography.
    * */

    private static final int SHIFT = 3; //fixed shift value since caesars cipher will only shift to the right by 3. Not too complicated of an algo

    @Override
    public String encrypt(String message) {
        return shiftMessage(message, -SHIFT);
    }

    @Override
    public String decrypt(String message) {
        return shiftMessage(message, SHIFT); // just reversing the process
    }


    /** Helper function to actually apply Caesars Cipher for encryption
     *
     * @param message - The message to be encrypted or decrypted
     * @param shiftValue - shift value that determines how many letters to shift the original
     * @return - the shifted String
     */
    private String shiftMessage(String message, int shiftValue)
    {
        StringBuilder shiftedMessage = new StringBuilder(); // since strings are "immutable" I need to use this StringBuilder: https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
        for(char character : message.toCharArray()) // iterating through each character
        {
            if(Character.isLetter(character)) // check to see if it is indeed a letter
            {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int shiftedIndex = (character - base + shiftValue) % 26;
                if(shiftedIndex < 0) shiftedIndex += 26; // this will aid if the user enters either x y or z, to wrap back around to the beginning of the alphabet
                character = (char) (base + shiftedIndex);
            }
            shiftedMessage.append(character);
        }
        return shiftedMessage.toString();
    }
}
