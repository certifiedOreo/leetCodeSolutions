class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                HashMap<Integer, Integer> myMap2 = new HashMap<>();

        int[] ans = new int[nums1.length];
        
     
        
        Stack<Integer> myStack = new Stack<>();
        
        //push the first node to stack
        myStack.push(nums2[0]);
        
        //for each next element
        for(int i=1; i<nums2.length; i++){
            
            //if stack is empty then push the next element to the stack
            if(myStack.empty()==true){
                myStack.push(nums2[i]);
                continue;
            }
            
            
            //while we are able to find the NGE of top of stack, keep popping it and that next )nums2[i]) is the NGE of all popped elements
            while(myStack.empty()==false && nums2[i]>myStack.peek()){
                myMap2.put(myStack.pop(), nums2[i]);
            }
            
            
            
            //if curr next element is no more NGE for any number then push itself to the stack for its NGE
            myStack.push(nums2[i]);
            
        
    }
        
        
        
        //if the stack is still not empty and all next elements have been checked then all these elements do not have any NGE
        while(myStack.empty()==false){
            myMap2.put(myStack.pop(), -1);
        }
        
        for(int i=0; i<nums1.length; i++){
            ans[i] = myMap2.get(nums1[i]);
        }
        
        return ans;
}
    
    
}
