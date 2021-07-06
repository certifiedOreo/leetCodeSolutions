
  struct TreeNode {
     int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
   };
 



class Solution {

    
    public:
    int maxPathSumUtility(TreeNode *root, int &ans){
        if(root==NULL){
            return 0;
        }
        
        int left = maxPathSumUtility(root->left, ans);
        int right = maxPathSumUtility(root->right, ans);
        
        int m1 = max( max(left, right) + root->val, root->val);
        int m2 = max( m1, left+right+root->val);
        ans = max( ans, m2);
        
        return m1;
    }
public:
    int maxPathSum(TreeNode* root) {
        int ans = INT_MIN;
        
        maxPathSumUtility(root, ans);
        
        return ans;
        
    }
};