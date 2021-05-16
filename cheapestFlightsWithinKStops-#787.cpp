#include <iostream>
#include <vector>
using namespace std;


class Solution {
    
    
    void prunedDfs(vector< pair<int, int> > graph[], int n,int src, int dst, int k, vector<bool> isVisited, int minPrice, int currPrice){
        
        if(k<-1){
            return;
        }
        if(src==dst){
            minPrice = min(minPrice, currPrice);
            return;
        }
        
            isVisited[src] = true;
            
            for(int i = 0; i< graph[src].size(); i++){
                
                        if(!isVisited[graph[src][i].first] && (currPrice + graph[src][i].second <= minPrice)){
                            prunedDfs( graph, n, graph[src][i].first, dst, k-1, isVisited, minPrice, currPrice + graph[src][i].second);
                        }
            } 
        
        isVisited[src] = false; 
    }
    
public:
    int findCheapestPrice(int n, vector<vector<int> >& flights, int src, int dst, int k) {
        vector< pair<int, int> > graph[n];

        
        for(int i=0; i<flights.size(); i++){
            pair<int, int> p;
            p.first = flights[i][1];
            p.second = flights[i][2];
            graph[flights[i][0]].push_back(p);
        }
        
        int minPrice = INT_MAX;
     vector<bool> isVisited(n+1, false);

        prunedDfs(graph, n, src, dst, k , isVisited, minPrice, 0);
        
        if(minPrice==INT_MAX){
            return -1;
        }
        return minPrice;
    }
        
        
};


int main(){

    Solution obj;
    int n = 3;
    vector<vector<int> > flights;
    vector<int> v1;
    v1.push_back(0);
    v1.push_back(1);
    v1.push_back(100);

    vector<int> v2;
    v2.push_back(1);
    v2.push_back(2);
    v2.push_back(100);

    vector<int> v3;
    v3.push_back(0);
    v3.push_back(2);
    v3.push_back(500);

    flights.push_back(v1);
    flights.push_back(v2);
    flights.push_back(v3);
    int src = 0;
    int dst=2;
    int k = 1;

    cout<<obj.findCheapestPrice(n, flights, src, dst, k)<<"\n";







    return 0;
}