class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        
        while(right < arr.length){
            // System.out.println(right);
            if(arr[right] == ' '){
                // System.out.println(left);
                // System.out.println(right);
                reverse(arr, left, right - 1);
                right++;
                left = right;
            } else {
                right++;
            }
        }
        
        // System.out.println(left);
        // System.out.println(right);
        if(left != right - 1){
            reverse(arr, left, right-1);
        }
        
        return String.valueOf(arr);
    }
    
    public void reverse(char[] arr, int left, int right){
        while(left <= right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}