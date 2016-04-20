package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by AKHIL on 12-Apr-16.
 */
public class ConstructTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("InOrder Traversal of Tree recursively:");
        inOrder(root);
        System.out.println("\n");
        System.out.println("PreOrder Traversal of Tree recursively:");
        preOrder(root);
        System.out.println("\n");
        System.out.println("PostOrder Traversal of Tree recursively:");
        postOrder(root);
        System.out.println("\n");
        System.out.println("InOrder Traversal of Tree iteratively:");
        iterInOrder(root);
        System.out.println("\n");
        System.out.println("PreOrder Traversal of Tree iteratively:");
        iterPreOrder(root);
        System.out.println("\n");
//        System.out.println("PostOrder Traversal of Tree iteratively:");
//        iterPostOrder(root);
//        System.out.println("\n");
        System.out.println("Level Order Traversal of Tree:");
        levelOrder(root);
        System.out.println("\n");

    }

    public static void levelOrder(TreeNode root) {
        if(root==null)
            return;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode temp = root;
        queue.offer(root);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
        queue.clear();
    }

    private static void iterPostOrder(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> S = new Stack<>();
        TreeNode temp = root;
        S.push(root);
        while(!S.isEmpty()){
         while(root!=null){
             if(S.size()==1){
                 S.pop();
             }
             if(root.right !=null){
                 S.push(root.right);
             }
             S.push(root.right);
             root = root.left;
         }
            root = S.pop();
            if(root.right!=null && root.right.data == S.peek().data){
                S.pop();
                S.push(root);
                root = root.right;
            }
            else{
                System.out.print(root.data + " ");
                root = null;
            }
        }
        S.clear();
    }

    private static void iterInOrder(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> S = new Stack<>();
        while(true){
            while(root!=null){
                S.push(root);
                root = root.left;
            }
            if(S.isEmpty())
                break;
            root = S.pop();
            System.out.print(root.data + " ");
            root=root.right;
        }
        S.clear();
    }

    private static void iterPreOrder(TreeNode root) {
        if(root==null)
            return;
        Stack<TreeNode> S = new Stack<>();
        while(true){
            while(root!=null){
                System.out.print(root.data + " ");
                S.push(root);
                root = root.left;
            }
            if(S.isEmpty())
                break;
            root = S.pop();
            root=root.right;
        }
        S.clear();
    }

    public static void postOrder(TreeNode root) {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root) {
        if(root==null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}