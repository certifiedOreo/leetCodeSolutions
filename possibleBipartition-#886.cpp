#include <iostream>
#include <queue>
#include <vector>
using namespace std;



class Solution {
    
    
    bool color(vector<int> g[], int n, int node, vector<int> colorArr){
        queue<int> myQ;
        myQ.push(node);
        colorArr[node]=1; 
        
        while(!myQ.empty()){
            int curr = myQ.front();
            myQ.pop();
            
            vector<int> :: iterator nbr;
            //work on nbrs of curr
            for(nbr = g[curr].begin(); nbr!=g[curr].end(); nbr++){
                if(colorArr[*nbr] == colorArr[curr]){
                    return false;
                }
                if(colorArr[*nbr]==-1){  //if nbr is uncolored
                    colorArr[*nbr] = colorArr[curr] xor 1;   //then color it with opposite color of curr
                    myQ.push(*nbr);
                }
            }
        }
        return true; //if whole graph is completely colored without any problem then return true
    }
public:
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        //make a graph with edge blw dislike[i][0] & dislike[i][1]
        vector<vector<int> > :: iterator edge;
        
        vector<int> graph[n+1];   //adjacency list to represent graph
        
        for(edge= dislikes.begin(); edge!=dislikes.end(); edge++){
            graph[(*edge)[0]].push_back((*edge)[1]);
            graph[(*edge)[1]].push_back((*edge)[0]);

            
        }
        
        vector<int> colorArr(n+1, -1);  //arr to store color of each node
        
        for(int node =1 ; node<=n; node++){
            if(colorArr[node]==-1){ //if node is uncolored
                if(!color(graph, n, node, colorArr)){  //if graph successfully colored then return true
                    return false;
                }
                
            }
        }
        
        return true;
        
    }
};