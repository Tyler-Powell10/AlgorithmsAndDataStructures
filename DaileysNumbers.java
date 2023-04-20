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
        System.out.println("4. Exit");

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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
