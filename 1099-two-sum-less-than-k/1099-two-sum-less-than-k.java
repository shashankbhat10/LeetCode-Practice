class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int sum = Integer.MIN_VALUE;
        while(i < j){
            int tempSum = nums[i] + nums[j];
            System.out.println(tempSum);
            if(tempSum > k)
                j--;
            else if(tempSum < k){
                sum = Math.max(sum, tempSum);
                i++;
            } else {
                j--;
            }
        }
        
        // System.out.println("i: " + nums[i] + ", j: " + nums[j]);
        
        return sum == Integer.MIN_VALUE ? -1 : sum;
    }
}