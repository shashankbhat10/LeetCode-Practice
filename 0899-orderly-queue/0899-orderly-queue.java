class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1){ 
            char []ch=s.toCharArray();
            Arrays.sort(ch);
            String snew=new String(ch);
            return snew;
        }
        
        String ans=s;
        StringBuilder sb=new StringBuilder(s);
        
        for(int i=0;i<s.length();i++){
            char ch=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            String snew=sb.toString();
            
            if(ans.compareTo(snew)>0){
                ans=snew;
            }
        }
        
        return ans;
    }
}