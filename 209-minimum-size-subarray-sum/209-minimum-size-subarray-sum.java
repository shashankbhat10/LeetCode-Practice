class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right];
            
            while(sum >= target){
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        System.out.println(left);
        System.out.println(right);
        if(minLength == Integer.MAX_VALUE)
            return 0;
        
        return minLength;
    }
}