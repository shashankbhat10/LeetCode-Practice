class Solution {
    public int compress(char[] chars) {
        int i=0;
        int res = 0;
        int index = 0;
        while(i < chars.length){
            int count = 0;
            char ch = chars[i];
            while(i+count < chars.length && chars[count+i] == ch){
                count++;
            }
            chars[index++] = ch;
            if(count != 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[index++] = c;
                }
            }
            i += count;
        }
        
        return index;
    }
}