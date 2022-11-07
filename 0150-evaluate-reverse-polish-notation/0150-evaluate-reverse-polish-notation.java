class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        
        for(int i=0; i<tokens.length; i++){
            if(Character.isDigit(tokens[i].charAt(0)) || (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)){
                stack.push(tokens[i]);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int temp = 0;
                switch(tokens[i]){
                    case "+": temp = num1 + num2;
                        break;
                    case "-": temp = num2 - num1;
                        break;
                    case "*": temp = num1 * num2;
                        break;
                    case "/": temp = num2 / num1;
                        break;
                }
                
                stack.push(String.valueOf(temp));
            }
            System.out.println("size: " + stack.size() + ", top: " + stack.peek());
            // System.out.println(stack.size());
        }
        
        return Integer.parseInt(stack.pop());
    }
}