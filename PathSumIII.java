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
class PathSumIII {
    
    
    public int rootAccepted(TreeNode root, int targetSum){
        if(root==null) return 0;
        int res=0;
        if(root.val == targetSum) { res++;
                                  }
        res+=rootAccepted(root.left, targetSum-root.val);
        res+=rootAccepted(root.right, targetSum-root.val);
        return res;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        return pathSum(root.left, targetSum) + rootAccepted(root, targetSum)+ pathSum(root.right, targetSum);
        
        
        
    }
}
