package Tree;

public class TreeNode {
    TreeNode left,right;
    int data;

    TreeNode(){}

    TreeNode(int data){
        this.data = data;
        this.left = this.right = null;
    }
}
