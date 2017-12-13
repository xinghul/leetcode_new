class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] ways = new int[s.length() + 1];
        ways[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--)
        {
            char ch = s.charAt(i);
            int count = 0;

            if (ch != '0') {
                count += ways[i + 1];
            }
            if (i < s.length() - 1) {
                char nextCh = s.charAt(i + 1);
                int val = Character.getNumericValue(ch) * 10 + Character.getNumericValue(nextCh);

                if (val >= 10 && val <= 26) {
                    count += ways[i + 2];
                }
            }

            ways[i] = count;
        }

        return ways[0];
    }
}

// 12
// ways[2] = 1
// ways[1] = 1
// ways[0] = 1 + 1 = 2

// ""