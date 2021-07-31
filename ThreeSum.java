class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // List<List<Integer> > ans = new ArrayList<>();
                Set<List<Integer>> triplets = new HashSet<>();
       List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);

        
        for(int i=0; i<list.size(); i++){
                     
            int left = i+1;
            int right = nums.length-1;
            
            while(left<right){
                int sum = list.get(i)+list.get(left) +list.get(right);
                
                if(sum>0){
                    right--;
                }
                else if(sum==0){
                    
                    
                    List<Integer> temp = new LinkedList<>();
                        temp.add(list.get(i));
                            temp.add(list.get(left));
                                                temp.add(list.get(right));
                        
                        triplets.add(temp);
                    left++;
                    
                }
                else{
                    left++;
                }
            }
            
            
        }
                List<List<Integer> > ans = new ArrayList<>(triplets);

        
        
        return ans;
        
    }
}
