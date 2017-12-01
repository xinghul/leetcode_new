class Solution {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++)
        {
            char ch = chs[i];

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);

                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    
                    stack.pop();
                    
                    break;
                    
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    
                    stack.pop();
                    
                    break;
                    
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    
                    stack.pop();
                    
                    break;
                
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }
}