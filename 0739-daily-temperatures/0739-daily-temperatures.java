class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
         int ans[]=new int[n];
         Stack<Integer> stk = new Stack<>();
         for(int i=n-1; i>=0; i--) {
                // a better greater number is found at position i ,  for anyone before i!
                while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]) {
                     stk.pop();  // remove position bigger than i that have small values , temp[i] is better!
                }
             ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
             stk.push(i);
         }
        return ans;
    }
}