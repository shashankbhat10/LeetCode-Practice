class Solution {
    public boolean isStrobogrammatic(String num) {
        // char[] arr = num.toCharArray();
        // for(int i=0; i<=arr.length/2; i++){
        //     // System.out.println(i);
        //     if(i == 0 && arr[arr.length - i - 1] == '0')
        //         return false;
        //     else if(arr[i] != '6' && arr[i] != '9' && arr[i] != '8')
        //         return false;
        //     else if(arr[i] == '6' && arr[arr.length - i - 1] != '9')
        //         return false;
        //     else if(arr[i] == '9' && arr[arr.length - i - 1] != '6')
        //         return false;
        //     else if(arr[i] == '8' && arr[arr.length - i - 1] != '8')
        //         return false;
        // }
        // return true;
        
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }
}