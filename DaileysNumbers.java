/*
 * Tyler Powell
 * Frank N
 * Nick Philips 
 * 
 * add documentation here
 * 
 * 
 */


import java.util.*;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class DaileysNumbers {
    // recursivley builts the tree based on depth, parent, and grandparent values
    public static void treeBuilder(TreeNode node, int depth, int parent, int grandparent) {
        if (depth == 0) {
            return;
        }
        node.left = new TreeNode(node.value + grandparent);
        node.right = new TreeNode(node.value + parent);
        treeBuilder(node.left, depth - 1, node.value, parent);
        treeBuilder(node.right, depth - 1, parent, node.value);
    }

    // returns list of nodes in preorder
    public static List<Integer> preOrderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.add(node.value);
            result.addAll(preOrderTraversal(node.left));
            result.addAll(preOrderTraversal(node.right));
        }
        return result;
    }

    // returns list of nodes in inorder
    public static List<Integer> inOrderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inOrderTraversal(node.left));
            result.add(node.value);
            result.addAll(inOrderTraversal(node.right));
        }
        return result;
    }

    // returns list of nodes in postorder
    public static List<Integer> postOrderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.addAll(postOrderTraversal(node.left));
            result.addAll(postOrderTraversal(node.right));
            result.add(node.value);
        }
        return result;
    }

    // keeps track of times a number is in the tree
    public static void countTracker(TreeNode node, int[] counts, int depth, int maxDepth) {
        if (node == null || depth > maxDepth) {
            return;
        }

        if (node.value < counts.length) {
            counts[node.value]++;
        }

        countTracker(node.left, counts, depth + 1, maxDepth);
        countTracker(node.right, counts, depth + 1, maxDepth);
    }

    // prints out missing numbers in the tree
    public static void missingNumbers(TreeNode node, boolean[] present, int depth, int maxDepth) {
        if (node == null || depth > maxDepth) {
            return;
        }

        if (node.value < present.length) {
            present[node.value] = true;
        }

        missingNumbers(node.left, present, depth + 1, maxDepth);
        missingNumbers(node.right, present, depth + 1, maxDepth);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the tree depth between 2 and 26: ");
        int treeDepth = scanner.nextInt();

        TreeNode root = new TreeNode(3);
        treeBuilder(root, treeDepth - 1, 2, 1);

        System.out.println("traversal options");
        System.out.println("1. preOrderTraversal");
        System.out.println("2. inOrderTraversal");
        System.out.println("3. postOrderTraversal");
        System.out.println("4. missing numbers and counts");
        System.out.println("5. exit");

        int choice;
        do {
            System.out.print("choose an option ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("preOrderTraversal traversal: " + preOrderTraversal(root));
                    break;
                case 2:
                    System.out.println("inOrderTraversal traversal: " + inOrderTraversal(root));
                    break;
                case 3:
                    System.out.println("postOrderTraversal traversal: " + postOrderTraversal(root));
                    break;
                case 4:
                    int maxNumber = root.right.value;
                    int
                    [] counts = new int[maxNumber + 1];
                    countTracker(root, counts, 1, treeDepth);

                    System.out.println("Counts:");
                    for (int i = 1; i <= maxNumber; i++) {
                        System.out.println(i + ": " + counts[i]);
                    }
                    boolean[] present = new boolean[maxNumber + 1];
                    missingNumbers(root, present, 1, treeDepth);
                    System.out.print("Missing: ");
                    for (int i = 1; i <= maxNumber; i++) {
                        if (!present[i]) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("invalid input");
            }
        } while (choice != 5);

        scanner.close();
    }
}
