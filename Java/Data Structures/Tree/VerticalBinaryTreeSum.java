package Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by AKHIL on 13-Apr-16.
 */
public class VerticalBinaryTreeSum {
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

        System.out.println("Vertical Sums for columns are:");
        Map<Integer,Integer> map = new TreeMap<>();
        VerticalSum(root,map,0);
        for(Map.Entry m:map.entrySet())
            System.out.println("Column="+ m.getKey() + ", Sum=" + m.getValue());
    }

    private static void VerticalSum(TreeNode root, Map<Integer, Integer> map, int key) {
        if(root==null)
            return;
        if(!map.containsKey(key)){
            map.put(key,0);
        }
        VerticalSum(root.left,map,key-1);
        map.put(key,map.get(key) + root.data);
        VerticalSum(root.right,map,key+1);
    }
}