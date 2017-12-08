class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums) 
        {
            set.add(num);
        }

        int longest = 0;
        for (int num: set)
        {
            if (!set.contains(num - 1)) {
                int length = 1;
                int tmp = num;
                while (set.contains(tmp + 1)) {
                    length++;
                    tmp++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}