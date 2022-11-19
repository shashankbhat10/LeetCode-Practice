class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int n = s.length();
        int ans = 0;
        while(i < n) {
            char ch = s.charAt(i);
            if(st.size()==0) {
                st.push(i);
                i++;
            } else {
                int top = st.peek();
                char bracket = s.charAt(top);
                if(ch == ')' && bracket == '(') {
                    st.pop();
                    i++;
                } else {
                    st.push(i);
                    i++;
                }
            }
        }
        i = n;
        if (st.size()==0) {
            ans = Math.max(ans, s.length());
        }
        while(st.size()!=0) {
            int val = st.pop();
            ans = Math.max(ans, i-val-1);
            i = val;
        }
        ans = Math.max(ans, i);
        return ans;


        
    }
}