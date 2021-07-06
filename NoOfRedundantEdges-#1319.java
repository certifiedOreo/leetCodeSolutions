import java.util.*;

class NoOfRedundantEdges { //change class name to Solution whilt testing the code in leetcode
    
    
    public static void DFS(ArrayList<ArrayList<Integer> > graph,Boolean[] visited, int curr){
        visited[curr] = true;
        
        for(int nbr : graph.get(curr)){
            if(visited[nbr]==false){
                DFS(graph, visited, nbr);
            }
        }
    }


public int makeConnected(int n, int[][] connections) {
    int edges=0;
    
    
    Boolean[] visited = new Boolean[n];
    //initializing arrays
    Arrays.fill( visited, Boolean.FALSE);
    
    ArrayList<ArrayList<Integer> > graph = new  ArrayList<ArrayList<Integer> >();
    for(int i=0; i<n; i++){
        graph.add(new ArrayList<Integer>());
    }
    
    
    //1 make the adjacency list
    for(int e=0; e<connections.length ; e++){
        graph.get(connections[e][0]).add(connections[e][1]);
        graph.get(connections[e][1]).add(connections[e][0]);
        edges+=1;
    }
    
    
    //count no. of components
    int components = 0;
    for(int i=0; i<n; i++){
        if(visited[i]==false){
            components+=1;
            DFS(graph, visited, i);
        }
        
    }
    
    
    //count no. of redundant edges
    int redundantEdges = edges - ((n-1)- components-1 );
    if(edges< n-1){  
        return -1;
    }
    else if(redundantEdges >= components-1){
        return components-1;
    }
    return -1;
    
}
}