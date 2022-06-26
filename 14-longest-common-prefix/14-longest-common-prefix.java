class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            boolean breakLoop = false;
            for(int j=0; j<strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    breakLoop = true;
                    break;
                }
            }
            
            if(breakLoop)
                break;
            else
                result += String.valueOf(c);
        }
        return result;
    }
}