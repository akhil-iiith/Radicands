package Tree;

import java.util.ArrayList;

public class PrintRootToLeafPaths {
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

        PrintAllPathsRecurs(root);
    }

    private static void PrintAllPathsRecurs(TreeNode root) {
        int path[] = new int[10];
        PrintAllPathsRecursUtil(root,path,0);
    }

    private static void PrintAllPathsRecursUtil(TreeNode root, int[] path, int pathLen) {
        if(root==null)
            return;
        path[pathLen++] = root.data;
        if(root.left == null && root.right==null) {
            printArray(path,pathLen);
        }
        PrintAllPathsRecursUtil(root.left,path,pathLen);
        PrintAllPathsRecursUtil(root.right,path,pathLen);

    }

    private static void printArray(int[] path, int pathLen) {
        for(int i=0;i<pathLen;i++){
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }
}
