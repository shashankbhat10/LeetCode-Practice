class Solution {
    public String minWindow(String s, String t) {
//         Set<Character> charT = new HashSet<Character>();
//         Map<Character, Integer> hm_s = new HashMap<Character, Integer>();
//         Map<Character, Integer> hm_t = new HashMap<Character, Integer>();
        
//         for(char c : t.toCharArray()){
//             hm_t.put(c, hm_t.getOrDefault(c, 0) + 1);
//             charT.add(c);
//         }
        
//         int end = 0;
//         int start = 0;
//         int minLength = 0;
//         int totalMatch = 0;
//         String res = "";
//         while(end < s.length()){
//             if(charT.contains(s.charAt(end))){
//                 hm_s.put(s.charAt(end), hm_s.getOrDefault(s.charAt(end), 0) + 1);
//                 int count_s = hm_s.get(s.charAt(end));
//                 int count_t = hm_t.get(s.charAt(end));
//                 if(count_s == count_t)
//                     totalMatch++;
                
//                 if(totalMatch == charT.size()){
//                     res = s.substring(start, end+1);
                    
//                     while(totalMatch == charT.size()){
//                         System.out.println("match: " + start + ", end:" + end);
//                         if(charT.contains(s.charAt(start))){
//                             res = s.substring(start, end + 1);
//                             System.out.println(res);
//                             hm_s.put(s.charAt(start), hm_s.get(s.charAt(start)) - 1);
//                             if(hm_s.get(s.charAt(start)) < hm_t.get(s.charAt(start)))
//                                 totalMatch--;
//                         }
//                         start++;
//                     }
                    
//                     System.out.println("start" + start);
//                     while(start < end && !charT.contains(s.charAt(start))){
//                         start++;
//                     }
//                     System.out.println(s.substring(start, end+1));
//                 }
//             }
//             end++;
//             System.out.println("end" + end);
//             // } else {
//             //     end++;
//             // }
//         }
        
//         return res;
        if(t.length() > s.length())
            return "";
        
        Map<Character, Integer> hmt = new HashMap<Character, Integer>();
        Map<Character, Integer> hms = new HashMap<Character, Integer>();
        
        int totalMatch = 0;
        for(int i=0; i<t.length(); i++){
            hmt.put(t.charAt(i), hmt.getOrDefault(t.charAt(i), 0) + 1);            
        }
        
        int start = 0;
        int end = 0;
        String min = "";
        while(end < t.length()){
            char c = s.charAt(end);
            if(hmt.containsKey(c)){
                hmt.put(c, hmt.get(c) - 1);
            
                if(hmt.get(c) == 0)
                    totalMatch++;
            }
            end++;
        }
        
        // System.out.println(hmt.keySet().size());
        
        if(totalMatch == hmt.keySet().size())
            return s.substring(start, end);
        
        while(end < s.length()){
            char c = s.charAt(end);
            // System.out.println("end: " + c);
            if(hmt.containsKey(c)){
                hmt.put(c, hmt.get(c) - 1);
                if(hmt.get(c) == 0)
                    totalMatch++;
                
                // System.out.println(totalMatch);
                if(totalMatch == hmt.keySet().size()){
                    // System.out.println("Start increasing start val");
                    while(start < end){
                        char cs = s.charAt(start);
                        // System.out.println("start: " + cs);
                        if(hmt.containsKey(cs)){
                            hmt.put(cs, hmt.get(cs) + 1);
                            
                            if(hmt.get(cs) == 1){
                                hmt.put(cs, 0);
                                break;
                            }
                            start++;
                        } else {
                            start++;
                        }
                    }
                    
                    String temp = s.substring(start, end + 1);
                    // System.out.println("temp: " + temp);
                    if(min == "" || min.length() > temp.length()){
                        // System.out.println("replace min");
                        min = temp;
                    }
                }
            }
            end++;
        }
        return min;
    }
}