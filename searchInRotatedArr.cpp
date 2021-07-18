class Solution {
    
    
    public int binarySearch(int[] nums, int key, int l, int h){
        
        while( l <= h){
            int mid = (l+h)/2;
            if(nums[mid]==key){
                return mid;
            }
            
            else if(nums[mid] <key){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        
        return -1;
        
        
        
    }
    
    public int pivotBinarySearch(int[] nums, int l, int h){
        
        while( l <= h){
            int mid = (l+h)/2;
            if(mid<nums.length-1 && nums[mid] > nums[mid+1]){. //if mid element is greater than element just right to it
               return mid;
            }
            else if(nums[l]<=nums[mid]){.  //if true, then elements till mid is still increasing and mid is not pivot so pivot lies in range (mid+1, h)
                l = mid+1;
            }
            else if(nums[l]>nums[mid]){.  //pivot is must in range(l, mid-1)
                h = mid-1;
            }

        }
        
        return -1;
        
        
        
    }
    
    
    public int search(int[] nums, int target) {
        int pivot = pivotBinarySearch(nums, 0, nums.length-1);
       // System.out.println(pivot);
        
        if(pivot==-1){.  //no pivot element then array is not rotated so do simple binary search
            return binarySearch(nums, target, 0, nums.length-1);
        }
        else if(nums[pivot]==target){
            return pivot;
        }
        else if( target<=nums[nums.length-1]){
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }

            return binarySearch(nums, target, 0, pivot-1);

    }

}
