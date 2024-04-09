public interface CryptographyWork {

    // made this an interface because maybe later on I can add different cryptographic algorithms, instead of just caesars cipher.
    String encrypt (String message);
    String decrypt(String message);
}
