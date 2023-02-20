import java.util.Scanner;  // Import the Scanner class
public class PalindromeApp {

	public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter in a phrase: ");
            String input = scanner.nextLine();

            // Use regular expression to replace any non-word characters with an empty string
            String strippedInput = input.replaceAll("\\W", "");

            // Convert all letters to lower case
            strippedInput = strippedInput.toLowerCase();

            System.out.println("Stripped input: " + strippedInput);
        }
    }
}
