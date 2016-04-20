package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by AKHIL on 12-Apr-16.
 */
public class PrintTreeReverse {
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

        System.out.println("Level Order Traversal of Tree from left to right starting from deepest level:");
        reverseLevelOrder(root);
        System.out.println("\n");
    }

    public static void reverseLevelOrder(TreeNode root) {
        if(root==null)
            return;
        TreeNode temp;
        Stack<TreeNode> S = new Stack<>();
        Deque<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while(!Q.isEmpty()){
            temp = Q.poll();
            if(temp.right!=null)
                Q.offer(temp.right);
            if(temp.left!=null)
                Q.offer(temp.left);
            S.push(temp);
        }
        while(!S.isEmpty()){
            System.out.print(S.pop().data + " ");
        }
        S.clear();
        Q.clear();
    }
}
