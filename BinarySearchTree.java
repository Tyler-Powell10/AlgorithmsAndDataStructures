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
        // Generate a random dataset of 100 integers ranging from 1-100

        //! changing this for testing 
        List<Integer> dataset = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
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
        List<Integer> sortedDataset2 = quicksort(dataset);
        long endTime1 = System.nanoTime();
        long timeElapsed1 = endTime1 - startTime1;

        // Traditional quicksort
        List<Integer> sortedDataset3 = new ArrayList<>(dataset);
        long startTime2 = System.nanoTime();
        Collections.sort(sortedDataset3);
        long endTime2 = System.nanoTime();
        long timeElapsed2 = endTime2 - startTime2;

        // Compare the two sorted datasets and print the processing times
        System.out.println("Sorted dataset 1 (quicksort within binary search tree): " + sortedDataset1);
        System.out.println("Sorted dataset 2 (our quicksort implementation): " + sortedDataset2);
        System.out.println("Processing time for quicksort within binary search tree: " + timeElapsed1 + " ns");
        System.out.println("Processing time for traditional quicksort: " + timeElapsed2 + " ns");
    }
}
