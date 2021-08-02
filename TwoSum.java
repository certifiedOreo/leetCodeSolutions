class TwoSum{
    
    
    class Node{
        int value;
        int index;
        public Node(int v, int i){
            this.value = v;
            this.index = i;
        }
    }
    
    class MyComparator implements Comparator<Node>{
       // @override
        public int compare(Node n1, Node n2){
            return n1.value-n2.value;
        }
    }
    
    
    
    
    public int[] twoSum(int[] nums, int target) {
        List<Node> list = new ArrayList<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            list.add(new Node(nums[i], i));
            
        }
        Collections.sort(list, new MyComparator());
        
        for(int i=0; i<list.size(); i++){
            int left = i;
            int right = list.size()-1;
            
            while(left<right){
                int sum = list.get(left).value+list.get(right).value;
                
                if(sum>target){
                    right--;
                }
                else if(sum==target){
                    ans[0] = list.get(left).index;
                    ans[1] =list.get(right).index;
                    return ans;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
        
    }
}
