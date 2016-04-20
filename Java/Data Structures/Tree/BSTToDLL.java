package Tree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by AKHIL on 15-Apr-16.
 */
public class BSTToDLL {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.left = new TreeNode(6);
        System.out.println("Level Order Traversal of Tree:");
        ConstructTree.levelOrder(root);
        System.out.println("\n");

        LinkedList<TreeNode> list = new LinkedList<>();
        DoBSTToDLL(root,list);
        Iterator<TreeNode> it = list.iterator();
        System.out.println("Linked List of given BST is:");
        while(it.hasNext()){
            System.out.print(it.next().data + "->");
        }
        System.out.println();
    }

    private static void DoBSTToDLL(TreeNode root, LinkedList<TreeNode> list) {
        if(root==null)
            return;
        DoBSTToDLL(root.left,list);
        list.addLast(root);
        DoBSTToDLL(root.right,list);
    }
}
