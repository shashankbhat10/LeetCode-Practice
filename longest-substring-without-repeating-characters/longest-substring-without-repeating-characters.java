class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int currLength = 0;
        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if(map.get(s.charAt(r)) == 2){
                maxLength = Math.max(maxLength, r - l);
                while(l <= r && map.get(s.charAt(r)) != 1){
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    l++;
                }
            }
            r++;
        }
        
        if(r != l)
            maxLength = Math.max(maxLength, r - l);
        
        return maxLength;
    }
}