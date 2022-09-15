class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while(end < s.length()){
            char cend = s.charAt(end);
            hm.put(cend, hm.getOrDefault(cend, 0) + 1);
            
            if(hm.keySet().size() > 2){
                maxLen = Math.max(maxLen, end - start);
                // System.out.println("Start");
                // System.out.println(end);
                // System.out.println(start);
                // System.out.println(maxLen);
                // System.out.println(hm.keySet().size());
                while(hm.keySet().size() > 2 && start < end){
                    char cstart = s.charAt(start);
                    hm.put(cstart, hm.get(cstart) - 1);
                    if(hm.get(cstart) == 0)
                        hm.remove(cstart);
                    start++;
                }
            }
                end++;
        }
        
        if(hm.keySet().size() < 3)
            return Math.max(maxLen, end - start);
        return maxLen;
    }
}