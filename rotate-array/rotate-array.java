class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return;
        
        k = k % nums.length;
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length-1);
        reverse(nums, 0, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}