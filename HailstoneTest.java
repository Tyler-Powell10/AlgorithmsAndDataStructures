import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Frank NKurunziza, Nicholas Phillips, and Tyler Powell
 * 
 * The purpose of this code is to prompt the user to input a number and generate a Hailstone sequence using that number. 
 * It creates an ArrayList to store the sequence and a Hailstone object to generate and manipulate the sequence. 
 * The code then outputs the Hailstone sequence and the length of the longest sequence generated.
 */

//This class provides a main method to test the Hailstone sequence generator.
public class HailstoneTest {
    public static void main(String[] args) {
        ArrayList<Integer> hailList=new ArrayList<>(); // Create a new ArrayList to store Hailstone sequence
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the largest number: ");
        int hailNumber=input.nextInt();
        Hailstone hail=new Hailstone(hailNumber,hailList); // Create a new Hailstone object with user input and hailList
        System.out.println("HailStone List: "+hail.hailNumber+" Longest sequence: "+hail.hailNumber.size() + " Starting with: " + hail.hailNumber.get(0));
    }
}