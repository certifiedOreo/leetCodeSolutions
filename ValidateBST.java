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
class ValidateBST {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    
    public boolean helper(TreeNode root, TreeNode min, TreeNode max){
        if(root==null){
            return true;
        }
        
        if( min!=null &&  min.val >= root.val){
            return false;
        }
        
         if( max!=null && max.val <= root.val){
            return false;
        }
        
        boolean leftResult = helper(root.left, min, root);
        boolean rightResult = helper(root.right, root, max);
        
        return leftResult && rightResult;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
        
        
        
    }
}