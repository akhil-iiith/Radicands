package Tree;

/**
 * Created by AKHIL on 12-Apr-16.
 */
public class AreGivenTreesMirror {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        System.out.println("Level Order Traversal of Tree1:");
        ConstructTree.levelOrder(root1);
        System.out.println("\n");

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(4);
        System.out.println("Level Order Traversal of Tree2:");
        ConstructTree.levelOrder(root2);
        System.out.println("\n");

        if(AreTreeMirrors(root1,root2))
            System.out.println("Trees are mirrors of each other");
        else
            System.out.println("Trees are not mirrors");
    }

    private static boolean AreTreeMirrors(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.data != root2.data)
            return false;
        return AreTreeMirrors(root1.left,root2.right) && AreTreeMirrors(root1.right,root2.left);
    }
}