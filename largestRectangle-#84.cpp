

class Solution {
public:
            int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        
        vector<int> left(n);
        vector<int> right(n);
        stack<int> myStack;   //to maintain the increasing order of bars based on height 

        for(int i=0; i<n; i++){
            if(myStack.empty()){
                left[i] = 0;
                myStack.push(i);
            }
            else{
                while(!myStack.empty() &&  heights[myStack.top()] >= heights[i]){ //pop till left smaller height bar found for each bar
                        myStack.pop();

                }
                left[i] = myStack.empty() ? 0 : myStack.top()+1;   //fill appropriate left bar for each bar
                myStack.push(i);   //done with curr bar

            }
        }


        while (!myStack.empty())
        {
            myStack.pop();
        }
        



         for(int i=n-1; i>=0; i--){
            if(myStack.empty()){
                right[i] = n-1;
                myStack.push(i);
            }
            else{
                while(!myStack.empty() && heights[myStack.top()] >= heights[i]){ //pop till left smaller height bar found for each bar
                        myStack.pop();

                }
                right[i] = myStack.empty() ? n-1 : myStack.top()-1;   //fill appropriate left bar for each bar
                myStack.push(i);   //done with curr bar

            }
        }

        int maxArea = 0;


        for(int i=0; i<n; i++){
            maxArea = max(maxArea, heights[i]*(right[i]-left[i]+1));
        }

        return maxArea;



        
        
    }



};