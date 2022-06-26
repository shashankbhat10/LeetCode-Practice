class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do{
            slow = digitSum(slow);
            fast = digitSum(digitSum(fast));
            if(slow == 1)
                return true;
        }while(slow != fast);
        
        return false;
    }
    
    private int digitSum(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
}