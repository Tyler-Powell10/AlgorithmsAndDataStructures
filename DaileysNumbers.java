import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class DaileysNumbers {
    public static void buildTree(TreeNode node, int depth, int parent, int grandparent) {
        if (depth == 0) {
            return;
        }
        node.left = new TreeNode(node.value + grandparent);
        node.right = new TreeNode(node.value + parent);
        buildTree(node.left, depth - 1, node.value, parent);
        buildTree(node.right, depth - 1, parent, node.value);
    }

    public static List<Integer> preOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.add(node.value);
            result.addAll(preOrder(node.left));
            result.addAll(preOrder(node.right));
        }
        return result;
    }

    public static List<Integer> inOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inOrder(node.left));
            result.add(node.value);
            result.addAll(inOrder(node.right));
        }
        return result;
    }

    public static List<Integer> postOrder(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result.addAll(postOrder(node.left));
            result.addAll(postOrder(node.right));
            result.add(node.value);
        }
        return result;
    }

    public static void countOccurrences(TreeNode node, int[] counts) {
        if (node == null) {
            return;
        }
    
        if (node.value < counts.length) {
            counts[node.value]++;
        }
    
        countOccurrences(node.left, counts);
        countOccurrences(node.right, counts);
    }
    

    public static boolean[] missingNumbers(TreeNode node, int maxNumber) {
        boolean[] present = new boolean[maxNumber + 1];
        missingNumbersHelper(node, present);
        return present;
    }
    
    public static void missingNumbersHelper(TreeNode node, boolean[] present) {
        if (node == null) {
            return;
        }
    
        if (node.value < present.length) {
            present[node.value] = true;
        }
    
        missingNumbersHelper(node.left, present);
        missingNumbersHelper(node.right, present);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the tree depth (between 2 and 26): ");
        int treeDepth = scanner.nextInt();

        TreeNode root = new TreeNode(3);
        buildTree(root, treeDepth - 1, 2, 1);

        System.out.println("Traversal options:");
        System.out.println("1. Preorder");
        System.out.println("2. Inorder");
        System.out.println("3. Postorder");
        System.out.println("4. Missing numbers and counts");
        System.out.println("5. Exit");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Preorder traversal: " + preOrder(root));
                    break;
                case 2:
                    System.out.println("Inorder traversal: " + inOrder(root));
                    break;
                case 3:
                    System.out.println("Postorder traversal: " + postOrder(root));
                    break;
                case 4:
                    int maxNumber = root.right.value;
                    int[] counts = new int[maxNumber + 1];
                    countOccurrences(root, counts);

                    System.out.println("Counts:");
                    for (int i = 1; i <= maxNumber; i++) {
                        System.out.println(i + ": " + counts[i]);
                    }
                    boolean[] present = missingNumbers(root, maxNumber);
                    System.out.print("Missing: ");
                    for (int i = 1; i <= maxNumber; i++) {
                        if (!present[i]) {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

                   
