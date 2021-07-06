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

class RightViewBST{

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(q.size()!=0){
            int n = q.size();
            
            for(int i=0; i<n; i++){
                 TreeNode processed = q.remove();

                if(i==n-1){
                    ans.add(processed.val);
                }
                    
                    if(processed.left!=null){
                        q.add(processed.left);
                    }
                    
                                        if(processed.right!=null){
                        q.add(processed.right);
                    }
                    
                }
            
            
        }
        return ans;
        
    }
}