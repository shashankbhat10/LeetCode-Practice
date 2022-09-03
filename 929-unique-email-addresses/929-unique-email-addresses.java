class Solution {
    public int numUniqueEmails(String[] emails) {
        int result = 0;
        
        Set<String> set = new HashSet<String>();
        for(String email : emails){
            int i = 0;
            StringBuilder sb = new StringBuilder();
            boolean isdomain = false;
            while(i < email.length()){
                if(email.charAt(i) == '.' && !isdomain){
                    i++;
                    continue;
                } else if(email.charAt(i) == '+' && !isdomain){
                    while(email.charAt(i) != '@'){
                        i++;
                        isdomain = true;
                    }
                } else {
                    if(email.charAt(i) == '@')
                        isdomain = true;
                    sb.append(email.charAt(i));
                    i++;
                }
            }
            // System.out.println(sb.toString());
            set.add(sb.toString());
        }
        
        return set.size();
    }
}