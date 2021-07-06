/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class InvertBST {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public void swap(TreeNode root){
        if(root==null){
            return;
        }
        swap(root.left);  //left call
        swap(root.right);  //right call
        
        //now process the root node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        
       
    }
    
    
    public TreeNode invertTree(TreeNode root) {

        
        //traverse in postOrder and processed the root node (swap its left and right child)
        //i.e  1) left call  2) right call 3) process the root node (swap its subtrees)
        
            if(root==null){
                return null;
            }
        swap(root);
        
        return root;
    
        
    }
}