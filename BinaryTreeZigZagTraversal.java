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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null){
            
        return ans;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean oddLevel = true;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        while(q.size()!=0){
            
            int size = q.size();
            if(oddLevel==true){
                List<Integer> levelList = new ArrayList<>();
                
                for(int i=0; i<size; i++){
                    TreeNode front = q.remove();
                    levelList.add(front.val);
    
                
                    
                    if(front.left!=null){
                        s1.add(front.left);
                        
                    }
                    
                    if(front.right!=null){
                        s1.add(front.right);

                        
                    }
                    
                    
                }
                
                while(!s1.empty()){
                    TreeNode temp = s1.pop();
                    q.add(temp);
                    
                }
                
                
                    
                ans.add(levelList);
                oddLevel = false;
                    
                    
                }
            else{
                
                List<Integer> levelList = new ArrayList<>();
                
                for(int i=0; i<size; i++){
                    TreeNode front = q.remove();
                    levelList.add(front.val);
                    s2.add(front);
                    
                }
                    
                
                while(s2.empty()==false){
                    TreeNode temp = s2.pop();
                    
                    
                    if(temp.left!=null){
                        q.add(temp.left);
                        
                    }
                    
                        if(temp.right!=null){
                        q.add(temp.right);
                        
                    }
                }          
                ans.add(levelList);
                 oddLevel = true;
                }               
            }
  return ans;
     
    }
}
