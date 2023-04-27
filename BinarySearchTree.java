import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// create the nodes
class Node {
    Node left;
    Node right;
    int value;

    // set values 
    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }
}

// create the binary search tree
public class BinarySearchTree {
    //instanciate the root node
    private Node root;

    // set the root to null
    public BinarySearchTree() {
        root = null;
    }

    // method for inserting the integer
    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // method for in order traversals
    public void inorderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.value);
            inorderTraversal(node.right, list);
        }
    }

    // method for quicksorting 
    public static List<Integer> quicksort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int pivot = list.get(list.size() / 2);
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int value : list) {
            if (value < pivot) {
                left.add(value);
            } else if (value == pivot) {
                middle.add(value);
            } else {
                right.add(value);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(quicksort(left));
        result.addAll(middle);
        result.addAll(quicksort(right));
        return result;
    }

    public static void main(String[] args) {
        int numberOfRuns = 1000;
        long totalTimeElapsedQuickSortBST = 0;
        long totalTimeElapsedTraditionalQuickSort = 0;
    
        for (int run = 0; run < numberOfRuns; run++) {
            // Generate a random dataset of 30 integers ranging from 1-100
            List<Integer> dataset = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 5000; i++) {
                dataset.add(random.nextInt(100) + 1);
            }
    
            // QuickSort within binary search tree
            BinarySearchTree bst = new BinarySearchTree();
            long startTime1 = System.nanoTime();
            for (int value : dataset) {
                bst.root = bst.insert(bst.root, value);
            }
            List<Integer> sortedDataset1 = new ArrayList<>();
            bst.inorderTraversal(bst.root, sortedDataset1);
            long endTime1 = System.nanoTime();
            long timeElapsed1 = endTime1 - startTime1;
            totalTimeElapsedQuickSortBST += timeElapsed1;
    
            // Traditional quicksort
            List<Integer> sortedDataset2 = new ArrayList<>(dataset);
            long startTime2 = System.nanoTime();
            sortedDataset2 = quicksort(sortedDataset2);
            long endTime2 = System.nanoTime();
            long timeElapsed2 = endTime2 - startTime2;
            totalTimeElapsedTraditionalQuickSort += timeElapsed2;
        }
    
        long averageTimeElapsedQuickSortBST = totalTimeElapsedQuickSortBST / numberOfRuns;
        long averageTimeElapsedTraditionalQuickSort = totalTimeElapsedTraditionalQuickSort / numberOfRuns;
    
        System.out.println("Average processing time for quicksort within binary search tree: " + averageTimeElapsedQuickSortBST + " ns");
        System.out.println("Average processing time for traditional quicksort: " + averageTimeElapsedTraditionalQuickSort + " ns");
    }
    
}
