class Solution {
    public String licenseKeyFormatting(String s, int k) {
//         String result = "";
        
//         int len = s.length()-1;
//         int count = k;
        
//         while(len >= 0){
//             if(count == 0){
//                 result += "-";
//                 count = k;
//             } else if(!s.substring(len, len + 1).matches("-")){
//                 result += s.substring(len, len+1).toUpperCase();
//                 len--;
//                 count--;
//             } else {
//                 len--;
//             }
//         }
        
//         if(result.length() == 0)
//             return "";
//         if(result.charAt(result.length() - 1) == '-')
//             result = result.substring(0, result.length() - 1);
//         char[] charArr = result.toCharArray();
//         for(int i=0; i<charArr.length/2; i++){
//             char temp = charArr[i];
//             charArr[i] = charArr[charArr.length - 1 - i];
//             charArr[charArr.length - 1 - i] = temp;
//         }
        
//         return new String(charArr);
        
        StringBuilder sb = new StringBuilder();
        
        int len = s.length() - 1;
        int count = k;
        while(len >= 0){
            char c = s.charAt(len);
            if(c == '-'){
                len--;
                continue;
            }
            
            if(count == 0){
                sb.append("-");
                count = k;
                continue;
            }
            
            sb.append(Character.toUpperCase(c));
            len--;
            count--;
        }
        
        return sb.reverse().toString();
    }
}