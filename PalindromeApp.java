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
class isPalindromeSTACK {
// for stacks all we have to do is put each character into the stack individually using push
// after they are in the stack we can pop each out individually, this will give us the same thing backwards
// we can create a string variable holding the input being put in and then a string value holding the output of all the pops
// then all we have to do is compare these string values and check if they are the same 

}

class isPalindromeQUEUE {

}
  