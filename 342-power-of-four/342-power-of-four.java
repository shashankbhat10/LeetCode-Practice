class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;
        return (Math.log(n) / Math.log(2)) % 2 == 0;
    }
}