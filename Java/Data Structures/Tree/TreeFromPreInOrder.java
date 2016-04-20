package Tree;

public class TreeFromPreInOrder {
    private static int preIndex = 0;
    public static void main(String[] args) {
        int preOrder[] = {1,2,4,5,3,6,7};
        int inOrder[] = {4,2,5,1,6,3,7};
        TreeNode root = ConstructTreeFromGivenTraversals(preOrder,inOrder,0,6);
        ConstructTree.levelOrder(root);
    }

    private static TreeNode ConstructTreeFromGivenTraversals(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        TreeNode newNode;
        if(inStart>inEnd)
            return null;
        newNode = new TreeNode();
        newNode.data=preOrder[preIndex];
        preIndex++;
        if (inStart==inEnd){
            return newNode;
        }
        int inIndex = Search(inOrder,inStart,inEnd,newNode.data);
        newNode.left = ConstructTreeFromGivenTraversals(preOrder,inOrder,inStart,inIndex-1);
        newNode.right = ConstructTreeFromGivenTraversals(preOrder,inOrder,inIndex+1,inEnd);
        return newNode;
    }

    private static int Search(int[] inOrder, int inStart, int inEnd, int data) {
        int index=-1;
        for(int i=inStart;i<=inEnd;i++){
            if(inOrder[i]==data) {
                index= i;
                break;
            }
        }
        return index;
    }
}
