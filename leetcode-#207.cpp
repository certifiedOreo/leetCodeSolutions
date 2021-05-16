#include <iostream>
#include <queue>
#include <vector>
using namespace std;


class Solution {
    
    
    bool isCyclic(vector<int> g[], int n, int node, vector<int> isVisited){
        
        if(isVisited[node]==2){
            return true;
        }
        
        isVisited[node]=2;
        
            vector<int> :: iterator nbr;
        for( nbr= g[node].begin(); nbr!= g[node].end(); nbr++){
            if(isVisited[*nbr]!=1){
                if(isCyclic(g, n, *nbr, isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
public:
    bool canFinish(int numCourses, vector<vector<int> >& prerequisites) {
        
        vector<int> graph[numCourses];
        
        
        //making a directed graph
        for(int i=0; i<numCourses; i++){
            graph[ prerequisites[i][0]].push_back( prerequisites[i][1]);
        }
        
        vector<int> isVisited(numCourses, 0);
        
        for(int node=0; node<numCourses; node++){
            if(isVisited[node]==0){
                if(isCyclic(graph, numCourses, node, isVisited)){
                    return false;
                }
            }
        }
        return true;
        
        
        
    }
};


int main(){
    int n=2;
    Solution obj ;
         vector<vector<int> > preQ;
        // vector<int> v1;
         vector<int> v2;
        //  v1.push_back(0);
        //  v1.push_back(1);
         v2.push_back(1);
         v2.push_back(0);

         //preQ.push_back(v1);
         preQ.push_back(v2);


    cout<<obj.canFinish(n, preQ)<<endl;


    return 0;
}