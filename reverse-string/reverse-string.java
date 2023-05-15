class Solution {
    int index = 0;
    public void reverseString(char[] s) {
        if(index >= s.length / 2){
            return;
        }
        
        char ch = s[index];
        s[index] = s[s.length - 1 - index];
        s[s.length - 1 - index] = ch;
        index++;
        reverseString(s);
    }
    
}