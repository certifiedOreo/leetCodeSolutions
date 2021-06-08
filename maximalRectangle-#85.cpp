class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        
        int m = matrix.size();
        
        if(m==0){
            return 0;
        }
        int n = matrix[0].size();
        int maxArea = 0;
        
        vector<vector<int > > histograms(m, vector<int> (n));
        
        
        //forming the histogram for each row
        for(int col=0; col<n; col++){
            histograms[0][col] = matrix[0][col]=='1'? 1 : 0;
            
        }
        
        for(int row = 1; row<m; row++){
            for(int col=0; col<n; col++){
                histograms[row][col] = matrix[row][col]== '0' ? 0 : histograms[row-1][col]+1;
               
            }
        }
        
//          for(int row = 0; row<m; row++){
//             for(int col=0; col<n; col++){
//                 cout<<histograms[row][col]<<" ";
               
//             }
//              cout<<endl;
//         }




            //Now applying algo to find 'the largestRectangle' for each row in histogram matrix
            for(int histogram = 0; histogram<m; histogram++){
                
                int left[n];
                int right[n];
                stack<int> myStack;
                
                for(int i=0; i<n; i++){
                    if(myStack.empty()){
                        left[i] = 0;
                        myStack.push(i);
                    }
                    else{
                        while(!myStack.empty() && histograms[histogram][myStack.top()] >= histograms[histogram][i]){
                            myStack.pop();
                        }
                        left[i] = myStack.empty() ? 0 : myStack.top()+1;
                        myStack.push(i);
                    }
                    
                }
                
                
                while(!myStack.empty()){
                    myStack.pop();
                }
                
                
                
                for(int i=n-1; i>=0; i--){
                    if(myStack.empty()){
                     right[i] = n-1;
                        myStack.push(i);
                    }
                    else{
                        while(!myStack.empty() && histograms[histogram][myStack.top()] >= histograms[histogram][i]){
                            myStack.pop();
                        }
                        right[i] = myStack.empty() ? n-1 : myStack.top()-1;
                        myStack.push(i);
                    }
                    
                }
                
                int currMax = 0;
                for(int i=0; i<n; i++){
                    currMax = max( currMax, histograms[histogram][i]*(right[i] - left[i]+1) );
                }
                
                maxArea = max(currMax, maxArea);
            }
        
        
        return maxArea;
        
        
        
        
        
    }
};