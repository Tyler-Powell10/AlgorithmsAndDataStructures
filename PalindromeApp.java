//package stacksandqueues;

import java.util.Scanner;

public class PalindromeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
//        do {
//            System.out.print("Enter a phrase: ");
//            input = scanner.nextLine();
//
//            // Check if the input contains a digit
//            if (input.matches(".*\\d.*")) {
//                System.out.println("Input must not contain any numbers. Reinput phrase.");
//            }
//        } while (input.matches(".*\\d.*"));  // Loop until input contains no digits
//
//        // Use regular expression to replace any non-word characters with an empty string
//        String strippedInput = input.replaceAll("\\W", "");
//
//        // Convert all letters to lower case
//        strippedInput = strippedInput.toLowerCase();
//
//        System.out.println("New Input: " + strippedInput);

//        boolean isPalindromeUsingQueue = isPalindromeQUEUE(strippedInput);
//        boolean isPalindromeUsingStack = isPalindromeSTACK(strippedInput);
        System.out.print("Enter a phrase: ");
        input = scanner.nextLine();
        while (!input.equals("quit")) {
            String strippedInput = input.replaceAll("\\W", "");
            // Convert all letters to lower case
            strippedInput = strippedInput.toLowerCase();
            System.out.println("Phrase: "+strippedInput);
            System.out.println("Queue: "+isPalindromeQUEUE(strippedInput));
            System.out.println("Stack: "+isPalindromeSTACK(strippedInput));
                    
            if (isPalindromeQUEUE(strippedInput) && isPalindromeSTACK(strippedInput)) {
                System.out.println("Using a queue, we confirmed the input is a palindrome");
                System.out.println(" is a palindrome");
            } else {
//            System.out.println("Using a queue, we confirmed the input is not a palindrome");
                System.out.println(" is NOT a palindrome");

//        if (isPalindromeUsingStack) {
//            System.out.println("using a stack, we confirmed the input is a palindrome");
//        } else {
//            System.out.println("using a stack, we confirmed the input is not a palindrome");
//        }
            }
            System.out.print("Enter a phrase (or 'quit'): ");
            input = scanner.nextLine();
        }
    }
    // i think this is where we actually do the sorting of characters and checking if it is a palendrome 
    // we can input each character into the queue
    // then push each character to the stack
    // we can then pop a character from the stack and get a character from the queue - comparing each individually
    // if they are not equal then its not a palendrome
    // return true of false

    public static boolean isPalindromeQUEUE(String str) {
        Queue queue = new Queue(str.length());
        // Add each character of the string to the queue
        for (int i = 0; i < str.length(); i++) {
            queue.insert(str.charAt(i));
        }
        // Remove each character from the queue and compare it to the corresponding character in the original string
        for (int i =str.length()-1 ; i >=0; i--) {
            char c1 = str.charAt(i);
            char c2 = queue.remove();
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeSTACK(String str) {
        StackX stack = new StackX(str.length());
        // Add each character of the string to the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        // Pop each character from the stack and compare it to the corresponding character in the original string
        for (int i = 0; i < str.length(); i++) {
            char c1 = str.charAt(i);
            char c2 = stack.pop();
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
