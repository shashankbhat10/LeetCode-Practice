class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int i=0;
        int j=s.length() - 1;
        
        while(i < j){
            // System.out.println("i: " + i + ", " + "aeiouAEIOU".indexOf(arr[i]));
            while("aeiouAEIOU".indexOf(arr[i]) < 0 && i < j){
                i++;
            }
            while("aeiouAEIOU".indexOf(arr[j]) < 0 && i < j){
                j--;
            }
            
            if(i < j){
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        
        return String.valueOf(arr);
    }
}