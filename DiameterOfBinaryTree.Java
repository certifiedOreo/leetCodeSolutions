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
class Solution {
    
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        
        return Math.max(lHeight, rHeight)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        
        int currDiameter = lHeight+rHeight;   //case when Diameter includes the root node
        
        int lDiameter =  diameterOfBinaryTree(root.left);
        int rDiameter =  diameterOfBinaryTree(root.right);
        
        int temp = Math.max(lDiameter, rDiameter);
        
        return Math.max(currDiameter,temp);  
        
        
        
        
        
        
        
    }
}
