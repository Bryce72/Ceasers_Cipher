import java.io.IOException;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        /*
        * This class file was just the testing grounds to see if my code was working properly without the GUI.
        * There was plenty more code here before but it was lost before I started commiting it to my repo.
        * */
        CryptographyWork caesarsCipher = new CaesarsCipher();
        String message = "Hello";
        String message2 = "zzz";


        String encrypted = caesarsCipher.encrypt(message2);
        System.out.println("hello becomes:  " + encrypted);
    }
}
