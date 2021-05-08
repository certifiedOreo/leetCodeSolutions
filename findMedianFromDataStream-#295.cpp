#include <iostream>
#include <queue>
using namespace std;


class MedianFinder {
public:
    priority_queue<int , vector<int> > maxHeap;  //it will store first N/2+1 ordered elements
    priority_queue< int, vector<int>, greater<int> > minHeap;  //it will store rest elements in ordered way
    //minHeap.size() <= maxHeap.size() <= minHeap.size()+1;

    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        int n1 = maxHeap.size();
        int n2 = minHeap.size();
        
        
        //if both have equal size then prefer minHeap to add new element but maintain order
        if( n1==n2){
            if( n1==0){    //both heap is empty so push in maxHeap first
                maxHeap.push(num);
            }
            else{           //In this case both have non-zero equal size, so prefer maxHeap to add new element but take care of order
                if( num < minHeap.top()  ){ //in this case order will be maintained so directly push to maxHeap
                    maxHeap.push(num);
                }
                else{   //here order will get violate
                    int temp = minHeap.top();
                    minHeap.pop();   //pop top of minHeap and add it to maxHeap and add new data to minHeap this way order will be maintained
                    maxHeap.push(temp);
                    minHeap.push(num);
                    
                }
            }

        }
        else{               //in this case maxHeap.size = minHeap.size() +1,so prefer minHeap to add new element but take care of order
            if(num> maxHeap.top()){   //here order won't violate so directly add to minHeap
                minHeap.push(num);
                
            }
            else{              //int this case order will violate
                int temp = maxHeap.top();  //pop top of maxHeap and add it to minHeap and add new data to maxHeap, this way order will be maintained
                maxHeap.pop();
                minHeap.push(temp);
                maxHeap.push(num);
            }
        }
        
        
    }
    
    double findMedian() {
        int n1 = maxHeap.size();
        int n2 = minHeap.size();
        double median;
        
        if(n1==n2){   //if both have same size, then median = average of top element of two heaps
    median = ( maxHeap.top()*1.0+minHeap.top()*1.0 )/2;
        }
        else if(n1>n2){  //median = top of  maxHeap
            median = maxHeap.top();
        }
        
        return median;
        
        
    }
};
