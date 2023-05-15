class Solution {
    int[] fibNums = new int[31];
    public int fib(int n) {
        if(n == 0) {
            fibNums[0] = 0;
            return 0;
        }
        else if(n == 1) {
            fibNums[1] = 1;
            return 1;
        }
        else if(fibNums[n] != 0)
            return fibNums[n];
        else
            return fib(n - 1) + fib(n - 2);
    }
}