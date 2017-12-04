class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");

        Stack<String> stack = new Stack<>();

        int max = 0;
        stack.push(parts[0]);
        String prefix = "\t";
        for (int i = 1; i < parts.length; i++)
        {
            String part = parts[i];
            if (!part.startsWith(prefix)) {
              // calculate current length, update max
              max = Math.max(max, calculatePathLength(stack));
            }
            while (!part.startsWith(prefix)) {
              prefix = prefix.substring(1);

              stack.pop();
            }
            
            stack.push(part);

            prefix += "\t";
        }
        
        max = Math.max(max, calculatePathLength(stack));

        return max;
    }

    private int calculatePathLength(Stack<String> stack) {
        if (!stack.peek().contains(".")) {
          return 0;
        }

        int size = stack.size() - 1;
        for (String str: stack) {
            str = str.replace("\t", "");

            size += str.length();
        }

        return size;
    }
}