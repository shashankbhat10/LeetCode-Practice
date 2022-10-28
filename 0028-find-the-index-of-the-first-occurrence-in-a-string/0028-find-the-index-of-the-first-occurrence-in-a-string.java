class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        
        int i=0;
        int j=0;
        
        while(i < haystack.length()){
            // System.out.println("i: " + i + ", j: " + j);
            while(i < haystack.length() && haystack.charAt(i) != needle.charAt(0)){
                i++;
            }
            
            while(i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            
            if(j == needle.length()){
                index = i - j;
                break;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        
        return index;
    }
}