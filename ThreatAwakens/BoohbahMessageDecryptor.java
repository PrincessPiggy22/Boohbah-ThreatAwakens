import java.io.*;

/**
 * Boohbah Message Decryptor
 *
 * STORY: The Boohbah have intercepted a secret message from an unknown enemy.
 * Intelligence suggests it's encrypted with a Caesar cipher (shift unknown).
 * Your mission: Read the encrypted message, decrypt it, and write the 
 * decrypted message to a file. Then determine who is attacking!
 */
public class BoohbahMessageDecryptor {

    /**
     * Decrypts a Caesar cipher encrypted message by shifting each letter back by the given shift amount.
     * Non-letter characters remain unchanged.
     *
     * @param encrypted the encrypted message
     * @param shift the number of positions to shift back
     * @return the decrypted message
     */
    public static String decrypt(String encrypted, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encrypted.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    // Shift uppercase letters back by the given amount
                    char shifted = (char) (c - shift);
                    if (shifted < 'A') {
                        shifted = (char) (shifted + 26); // Wrap around
                    }
                    decrypted.append(shifted);
                } else {
                    // Shift lowercase letters back by the given amount
                    char shifted = (char) (c - shift);
                    if (shifted < 'a') {
                        shifted = (char) (shifted + 26); // Wrap around
                    }
                    decrypted.append(shifted);
                }
            } else {
                // Keep non-letter characters as-is
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {
        // TODO: Declare variables for file paths
        String inputFile = "C:\\Users\\mlpuryear\\IdeaProjects\\BoohbahThreatAwakens\\src\\encrypted_message.txt";
        String outputFile = "C:\\Users\\mlpuryear\\IdeaProjects\\BoohbahThreatAwakens\\src\\decrypted_message.txt";

        // TODO: Try-with-resources block to handle IOException
        // Include file operations within the try parentheses so resources are automatically closed
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

        // TODO: Read the encrypted message from the file (one line)
            String encryptedMessage = br.readLine();

        // TODO: Try different shift values (0-25) until you find a decryption that makes sense
        // Loop through possible shift values and print each decryption attempt
        // When you find one that looks like a real message, note the shift value!
            System.out.println("\n------------------------------------------\n| WARNING: INTERCEPTED ENCRYPTED MESSAGE |\n------------------------------------------");
            System.out.println("RUNNING BOOHBAH MESSAGE DECRYPTER...\n");

            for (int i = 0; i <= 25; i++) {
                System.out.println("Shift " + i + ":" + decrypt(encryptedMessage,i));
            } // Shift = 3

        // Once you've identified the correct shift value, use it to decrypt the message
            int correctShift = 3;
            String decryptedMessage = decrypt(encryptedMessage, correctShift);

        // TODO: Write the decrypted message to the output file
            try(FileWriter fw = new FileWriter(outputFile)){
                fw.write(decryptedMessage);
                System.out.println("\nDECRYPTED MESSAGE SAVED");
            }catch (IOException e){
                System.out.println("\n\nERROR: MESSAGE COULD NOT BE SAVED\n\n");
            }

        // TODO: Display results to console
            System.out.println("-----------------------\n| DECRYPTION COMPLETE |\n-----------------------");
            System.out.println("ENCRYPTED MESSAGE:\n" + encryptedMessage);
            System.out.println("DECRYPTED MESSAGE:\n" + decryptedMessage);
            System.out.println("\n-------------\n| !WARNING! |\n-------------");
            System.out.println("\nSTATUS:\nUNDER THREAT\nTHREAT IDENTIFIED:\nTHE TELETUBBIES\nTHREAT LVL:\nN\\A\n");

         } catch (IOException e) {
        // TODO: Handle the IOException appropriately
            System.out.println("\nERROR: MESSAGE COULD NOT BE FOUND");
         }
    }
}
