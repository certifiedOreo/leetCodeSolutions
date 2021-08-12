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
    public int findBottomLeftValue(TreeNode root) {
     
        List<List<Integer> > list = new ArrayList<>();
        int ans = -1;   //a randome to value to instantiate
        boolean found = false;
Queue<TreeNode> q = new LinkedList<>();        
        q.add(root);
        
        while(q.size()!=0){
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            
            for(int i=0; i<size; i++){
            TreeNode front = q.remove();
                levelList.add(front.val);
                
                if(front.left!=null){
                    q.add(front.left);
                }
                
                if(front.right!=null){
                    q.add(front.right);
                }
                
            }
            list.add(levelList);
            
            
        }
        
        return list.get(list.size()-1).get(0);
        
        
     
        
        
}
}
