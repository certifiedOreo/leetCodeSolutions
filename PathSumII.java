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
class PathSumII{
    
    
        public static List<List<Integer>> pathSum(TreeNode root, int target){
             List<List<Integer>> ans = new ArrayList<>();


       List<Integer> path = new ArrayList<>();


        dfs(root, target, ans, new ArrayList<>());

        return ans;

    }
    
    
    

    public static void dfs(TreeNode root, int target, List<List<Integer>> ans , List<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.val);
        target-=root.val;

        if(root.left==null && root.right==null){
            if(target==0){
                List<Integer>  list = new ArrayList(path);  //a valid answer
                ans.add(list);
            }

        }
        else{

            dfs(root.left, target, ans, path);
            dfs(root.right, target, ans, path);
        }

        path.remove(path.size()-1);  //backtrack!

    }
    
    
    
    
    
    
    
    
    
    
}
