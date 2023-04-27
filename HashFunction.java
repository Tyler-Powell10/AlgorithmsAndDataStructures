/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package stacksandqueues;

/**
 *
 * @author Frank NKurunziza
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the name of the input file:");
        
        // Open the file
        File file = new File("./src/samplefile1.txt"); // make sure to have your file named simplefile1.txt and it is placed in src folder
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        }

        // Create the hash table
        Hashtable<String, Integer> hash = new Hashtable<>();

        // Read each line and count the words
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toUpperCase();
            String[] words = line.replaceAll("[^A-Z]", " ").split("\\s+");

            for (String word : words) {
                if (word.isEmpty()) {
                    continue;
                }

                if (!hash.containsKey(word)) {
                    hash.put(word, 1);
                } else {
                    int count = hash.get(word);
                    hash.put(word, count + 1);
                }
            }
        }

        // Sort the hash table using a Java sort
        TreeMap<String, Integer> treeMap = new TreeMap<>(hash);

        // Print each word and its count in alphabetical order
        Iterator<String> itr = treeMap.keySet().iterator();
        while (itr.hasNext()) {
            String word = itr.next();
            int count = treeMap.get(word);
            System.out.println(word + ": " + count);
        }
    }
}
