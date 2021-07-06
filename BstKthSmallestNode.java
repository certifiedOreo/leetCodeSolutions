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

 import java.util.*;

class BstKthSmallestNode {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans=-1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        
        TreeNode curr = root;
        
  
            
            while( curr!=null){
            s.push(curr);
                curr = curr.left;
            }
                   
          
                    while(k!=0){
                        curr = s.pop();
                        k--;
                        if(k==0) return ans = curr.val;
                        
                        if(curr.right!=null){
                            curr = curr.right;
                        
                        
                        while(curr!=null){
                            s.push(curr);
                            curr = curr.left;
                        }
                        }
                    
        
    }
        return curr.val;
}
}