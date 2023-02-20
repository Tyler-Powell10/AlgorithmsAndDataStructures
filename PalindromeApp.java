import java.util.Scanner;

public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            System.out.print("Enter a phrase: ");
            input = scanner.nextLine();

            // Check if the input contains a digit
            if (input.matches(".*\\d.*")) {
                System.out.println("Input must not contain any numbers. Reinput phrase.");
            }
        } while (input.matches(".*\\d.*"));  // Loop until input contains no digits

        // Use regular expression to replace any non-word characters with an empty string
        String strippedInput = input.replaceAll("\\W", "");

        // Convert all letters to lower case
        strippedInput = strippedInput.toLowerCase();

        System.out.println("New Input: " + strippedInput);

        scanner.close();
    }
}

// i think this is where we actually do the sorting of characters and checking if it is a palendrome 
// we can input each character into the queue
// then push each character to the stack
// we can then pop a character from the stack and get a character from the queue - comparing each individually
// if they are not equal then its not a palendrome
// return true of false
class isPalindromeSTACK {

}

class isPalindromeQUEUE {
// for queues

}
  