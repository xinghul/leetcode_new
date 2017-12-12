class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++)
        {
            StringBuilder sb = new StringBuilder();

            int index = 0;
            while (index < result.length())
            {
                char ch = result.charAt(index);
                int count = 1;

                while (index < result.length() - 1 && result.charAt(index + 1) == ch)
                {
                  index++;
                  count++;
                }

                sb.append(count);
                sb.append(ch);

                index++;
            }

            result = sb.toString();
        }

        return result;
    }
}