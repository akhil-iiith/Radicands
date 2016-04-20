package Tree;

/**
 * Created by AKHIL on 14-Apr-16.
 */
public class FindLCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode(6);

        System.out.println("InOrder Traversal of Tree recursively:");
        ConstructTree.inOrder(root);
        System.out.println("\n");
        int value1=5;
        int value2=9;
        TreeNode LCANode = findLCAInTree(root,value1,value2);
        System.out.println("The least common ancestor for Nodes with values " + value1 + " & " + value2 + " is:" + LCANode.data );
    }

    private static TreeNode findLCAInTree(TreeNode root, int value1, int value2) {
        if(root==null)
            return root;
        if(root.data >= value1 && root.data<=value2)
            return root;
        else if(root.data < value1 && root.data <value2)
            root = findLCAInTree(root.right,value1,value2);
        else
            root = findLCAInTree(root.left,value1,value2);
        return root;
    }
}
