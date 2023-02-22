import java.util.Scanner;
import java.util.Stackx;
import java.Queue;

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

        boolean isPalindromeUsingQueue = isPalindromeQUEUE.checkPalindrome(strippedInput);
        boolean isPalindromeUsingStack = isPalindromeSTACK.checkPalindrome(strippedInput);

        if (isPalindromeUsingQueue) {
            System.out.println("Using a queue, we confirmed the input is a palindrome");
        } else {
            System.out.println("Using a queue, we confirmed the input is not a palindrome");
        }

        if (isPalindromeUsingStack) {
            System.out.println("using a stack, we confirmed the input is a palindrome");
        } else {
            System.out.println("using a stack, we confirmed the input is not a palindrome");
        }

        scanner.close();
    }
}

// if they are not equal then its not a palendrome
class isPalindromeQUEUE {
    public static boolean checkPalindrome(String str) {
        Queue queue = new Queue(str.length());
        // Add each character of the string to the queue
        for (int i = 0; i < str.length(); i++) {                //N
            queue.insert(str.charAt(i));
        }
        // Remove each character from the queue and compare it to the corresponding character in the original string
        for (int i = 0; i < str.length(); i++) {                //N
            char c1 = str.charAt(i);                            //N
            char c2 = queue.remove();                           //N
            if (c1 != c2) {                                     //1/2N
                return false;
            }
        }
        return true;                                            //1/2N
    }
                                                                // 5N
}

class isPalindromeSTACK {
    public static boolean checkPalindrome(String str) {
        StackX stack = new StackX(str.length());
        // Add each character of the string to the stack
        for (int i = 0; i < str.length(); i++) {        //N
            stack.push(str.charAt(i));
        }
        // Pop each character from the stack and compare it to the corresponding character in the original string
        for (int i = 0; i < str.length(); i++) {        //N
            char c1 = str.charAt(i);                    
            char c2 = stack.pop();
            if (c1 != c2) {                             //1/2N
                return false;
            }
        }
        return true;                                    //1/2N
    }
}                                                       // = 5N
  