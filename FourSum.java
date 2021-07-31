class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        
        Set<List<Integer>> mySet = new HashSet<>();
        
        List<Integer> newNums = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            newNums.add(nums[i]);
        }
        
        Collections.sort(newNums);
        
        for(int i=0; i<newNums.size()-3; i++){
            for(int j=i+1; j<newNums.size()-2; j++){
                
                int left = j+1;
                int right = newNums.size()-1;
                
                while(left<right){
                    int sum = newNums.get(i)+newNums.get(j)+newNums.get(left)+newNums.get(right);
                    
                    if(sum>target){
                        right--;
                    }
                    else if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(newNums.get(i));
                        temp.add(newNums.get(j));
                        temp.add(newNums.get(left));
                        temp.add(newNums.get(right));
                        
                        mySet.add(temp);
                        
                        
                        
                        left++;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        
                List<List<Integer> > ans = new ArrayList<>(mySet);
        
        
        return ans;
        
        
        
        
    }
}
