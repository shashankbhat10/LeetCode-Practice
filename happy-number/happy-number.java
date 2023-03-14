class Solution {
    public boolean isHappy(int n) {
//         int slow = n;
//         int fast = n;
        
//         do{
//             slow = digitSum(slow);
//             fast = digitSum(digitSum(fast));
//             if(slow == 1)
//                 return true;
//         }while(slow != fast);
        
//         return false;
        Set<Integer> set = new HashSet<Integer>();
        int temp = n;
        while(temp != 1){
            if(set.contains(temp))
                return false;
            set.add(temp);
            temp = digitSum(temp);
            // System.out.println(temp);
        }
        return true;
    }
    
    public int getSum(int n){
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
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