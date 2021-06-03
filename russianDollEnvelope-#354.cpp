class Solution {
    
    
    
    
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int len = envelopes.size();
    sort(envelopes.begin(), envelopes.end());   //sorted in asceding order
        
        int lis[len];
        
        for(int i=0; i<len; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if( (envelopes[i][0]>envelopes[j][0]) && (envelopes[i][1]>envelopes[j][1]) && (lis[i]<lis[j]+1)){
                    lis[i]+=1;
                    
                }
            }
        }
        
        int mx=0;
        
        for(int i=0; i<len; i++){
            mx = max(lis[i], mx);
        }
        
        return mx;
        
        
        
    }
};