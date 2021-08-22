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
    int ans=0;
    public void solve(TreeNode root, int condition){
       if(root==null){
           return;
       }
        
        if(root.val >=condition){
            this.ans++;
            condition = root.val;
        }
        
        if(root.left!=null){
            solve(root.left, condition );
        }
                if(root.right!=null){
            solve(root.right, condition );
        }
        
        
    }
    
    public int goodNodes(TreeNode root) {
        
        solve(root, root.val);
        return this.ans;
        
        
    }
}
