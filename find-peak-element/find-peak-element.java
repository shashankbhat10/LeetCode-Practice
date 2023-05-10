class Solution {
    public int findPeakElement(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        int mid = 0;
        while(low <= high) {
            mid = (high - low) / 2 + low;
            if(mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                break;
            } else if(mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return mid;
    }
}