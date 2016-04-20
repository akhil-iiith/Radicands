package Tree;

public class MirrorTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Level Order Traversal of Tree:");
        ConstructTree.levelOrder(root);
        System.out.println("\n");

        ConstructMirrorTree(root);
        System.out.println("Level Order Traversal of Mirror of given Tree:");
        ConstructTree.levelOrder(root);
        System.out.println("\n");
    }

    private static void ConstructMirrorTree(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp;
        ConstructMirrorTree(root.left);
        ConstructMirrorTree(root.right);
        if(root.left==null && root.right==null){
            return;
        }
        else{
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }
}