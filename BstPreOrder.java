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

class BstPreOrder {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root==null){
            return ans;
        }
        
        myStack.push(root);
        
        while(myStack.size()!=0){
            TreeNode top = myStack.pop();
            
            ans.add(top.val);
            if(top.right!=null){
                myStack.push(top.right);
                
            }
                        if(top.left!=null){
                myStack.push(top.left);
                
            }
            
            
            
        }
        
        return ans;
        
    }
}