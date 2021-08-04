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
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        int[] ans = new int[1];
        ans[0] = 0;
        dfs(root, targetSum, ans);
        return ans[0]==1;
        
    }
    
    public static void dfs(TreeNode root, int targetSum, int[] ans){
        if(root==null) return;
        
        targetSum-=root.val;
        
        if(root.left==null && root.right==null){
            if(targetSum==0){
                ans[0] =1;
                return;
            }
        }
        else{
            dfs(root.left, targetSum, ans);
            dfs(root.right, targetSum, ans);
        }
    }
}
