/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
               List<List<Integer>> ans = new ArrayList<>();
            
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(q.size()!=0){
            
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>();
            
            for(int child=0; child<levelSize; child++){
                Node front = q.remove();
                levelList.add(front.val);
                
                for(int i=0; i<front.children.size(); i++){
                    q.add(front.children.get(i));
                    
                }
                
                
            }
            
            ans.add(levelList);
            
            
            
        }
        
        return ans;
        
    }
}
