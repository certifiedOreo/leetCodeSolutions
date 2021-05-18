#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
    
    bool detectCycle_util(vector<vector<int>>& adj,vector<int>& visited,int v)
    {
        if(visited[v]==1)
            return true;
        if(visited[v]==2)
            return false;
        visited[v]=1;   //Mark current as visited
        for(int i=0;i<adj[v].size();++i)
            if(detectCycle_util(adj,visited,adj[v][i]))
                return true;
        visited[v]=2;   //Mark current node as processed
        return false;
    }
    //Cycle detection
    bool detectCycle(vector<vector<int>>& adj,int n)
    {
        vector<int> visited(n,0);
        for(int i=0;i<n;++i)
            if(!visited[i])
                if(detectCycle_util(adj,visited,i))
                    return true;
        return false;
    }

             
  
    
    void topoDfs(vector<vector<int> > &graph, int node, vector<bool> &isVisited, stack<int> &myStack){
        isVisited[node] = true;
        
        for(int nbr=0; nbr<graph[node].size(); nbr++){
                if(!isVisited[graph[node][nbr]]){
                    topoDfs(graph, graph[node][nbr], isVisited, myStack);
                }
            
        }
        myStack.push(node);
    }
    
    public:
     vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
         int n = numCourses;
         vector<vector<int> > graph(n);
         
         
         //constructing the directed graph
         for(int i=0;i< prerequisites.size(); i++){
             graph[prerequisites[i][1]].push_back(prerequisites[i][0]);
             
         }
         
         
        vector<int> ans;


         if(detectCycle(graph, n)){
             return ans;
         }
         
         vector<bool> isVisited(n, false);
         stack<int> myStack;
         
         for(int node=0; node<n; node++){
             if(!isVisited[node]){
                 topoDfs(graph, node, isVisited, myStack);
             }
         }
         
         
         while(!myStack.empty()){
             ans.push_back(myStack.top());
             myStack.pop();
         }
         
         
         return ans;
         
     }
    
    
    
    
};