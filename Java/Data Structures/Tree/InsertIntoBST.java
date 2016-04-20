package Tree;

public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println("InOrder Traversal of Tree:");
        ConstructTree.inOrder(root);
        System.out.println("\n");
        int value = 7;
        root = InsertValInBST(root,value);

        System.out.println("InOrder Traversal of Tree after Inserting/Inspecting given element:");
        ConstructTree.inOrder(root);
        System.out.println("\n");
    }

    private static TreeNode InsertValInBST(TreeNode root, int value) {
        if(root==null){
            TreeNode newNode = new TreeNode(value);
            root = newNode;
            return root;
        }
        if(root.data>value)
            root.left = InsertValInBST(root.left,value);
        else if(root.data < value)
            root.right = InsertValInBST(root.right,value);
        else{
            System.out.println("The Node with Value:" + value + " already exists in tree");
            return root;
        }
        return root;
    }
}
