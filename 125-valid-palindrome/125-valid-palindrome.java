class Solution {
    public boolean isPalindrome(String s) {
        List<Character> trimmedString = new ArrayList<Character>();
        
        String lowerCasedString = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            char c = lowerCasedString.charAt(i);
            
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                trimmedString.add(c);
            }
        }
        
        int len = trimmedString.size();
        if(len == 0)
            return true;
        for(int i=0; i<= len / 2; i++){
            if(trimmedString.get(i) != trimmedString.get(len - 1 -i))
                return false;
        }
        
        return true;
    }
}