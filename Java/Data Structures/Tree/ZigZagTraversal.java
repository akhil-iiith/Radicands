package Tree;

import java.util.Stack;

/**
 * Created by AKHIL on 13-Apr-16.
 */
public class ZigZagTraversal {
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

        System.out.println("ZigZag Traversal of Tree:");
        ZigZag(root);
        System.out.println("\n");
    }

    private static void ZigZag(TreeNode root) {
        if(root==null)
            return;
        int leftToRight=1;
        TreeNode temp;
        Stack<TreeNode> S1 = new Stack<>();
        Stack<TreeNode> S2 = new Stack<>();
        Stack<TreeNode> TEMP_STACK;
        S1.push(root);
        while(!S1.isEmpty()){
            temp = S1.pop();
            if(temp!=null){
                System.out.print(temp.data + " ");
                if(leftToRight==1) {
                    if (temp.left != null)
                        S2.push(temp.left);
                    if (temp.right != null)
                        S2.push(temp.right);
                }
                else{
                    if (temp.right != null)
                        S2.push(temp.right);
                    if (temp.left != null)
                        S2.push(temp.left);
                }
            }
            if(S1.isEmpty()){
                leftToRight = 1 - leftToRight;
                TEMP_STACK = S1;
                S1 = S2;
                S2 = TEMP_STACK;
            }
        }
        S1.clear();
        S2.clear();
    }
}