package Tree;

/**
 * Created by AKHIL on 14-Apr-16.
 */
public class DeleteNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode(6);
        System.out.println("InOrder Traversal of Tree:");
        ConstructTree.inOrder(root);
        System.out.println("\n");

        int value = 8;
        System.out.println("Node to be deleted from Tree is " + value);
        root = DeleteNode(root,value);

        System.out.println("InOrder Traversal of Tree after Deletion of Node with Value " + value + " is:");
        ConstructTree.inOrder(root);
        System.out.println("\n");
    }

    private static TreeNode DeleteNode(TreeNode root, int value) {
        TreeNode temp;
        if(root==null){
            System.out.println("Node with Value:" + value + " doesn't exist in Tree.");
            return root;
        }

        if(root.data > value){
            root.left = DeleteNode(root.left,value);
        }
        else if(root.data < value){
            root.right = DeleteNode(root.right,value);
        }
        else{
            if(root.left==null && root.right ==null)
            {
                root = null;
            }
            else if(root.left!=null && root.right!=null){
                 temp = FindMax(root.left);
                root.data = temp.data;
                root.left = DeleteNode(root.left,root.data);
            }
            else{
                temp = root;
                if(root.right==null){
                    root = root.left;
                }
                else{
                    root = root.right;
                }
                temp = null;
            }
        }
        return root;
    }

    private static TreeNode FindMax(TreeNode root) {
        if(root==null)
            return root;
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }
}
