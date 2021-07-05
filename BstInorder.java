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



class BstInorder {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        
        while(curr!=null || !myStack.empty()){
            
            while(curr!=null){
                myStack.push(curr);
                curr = curr.left;

            }
            
            curr = myStack.pop();
            ans.add(curr.val);
            
            
            curr = curr.right;
        }
        
        return ans;
       
}
}