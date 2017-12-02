class Solution {
    // naive approach
    public int findMaximumXOR(int[] nums) {
        // 1. find max number in nums, calculate the max number of power of 2, less than max number
        // 2. find numbers no less than the max number of power of 2
        // 3. loop through numbers found in step2, try all numbers

        int max = 0;
        int n;
        // O(n), O(1)
        for (int i = 0; i < nums.length; i++)
        {
            max = Math.max(nums[i], max);
        }

        // O(1), O(1)
        n = (int)(Math.log(max) / Math.log(2));
        int maxPowerTwo = (int)Math.pow(2, n);

        // O(n), O(n)
        ArrayList<Integer> possibleNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] >= maxPowerTwo) {
                possibleNumbers.add(nums[i]);
            }
        }

        // O(n^2), O(1)
        int maxXOR = 0;        
        for (int tmp: possibleNumbers) {
            for (int i = 0; i < nums.length; i++)
            {
                maxXOR = Math.max(tmp ^ nums[i], maxXOR);
            }
        }

        return maxXOR;
    }

    // refined approach
    public int findMaximumXOR(int[] nums) {
        // 1. get prefixes of numbers, from high to low, store into set. (num & (2^31 - 1) should be num itself)
        // 2. maintain current possible max value, which is obtained by trying out digits from high to low
        // 3. for each prefix, try new possble max value tmp = max | 1 << i
        // 4. loop through set, see if can find two prefixes p1 and p2, where p1 ^ p2 = tmp => set contains p2 = tmp ^ p1
        // 5. if so, update max = tmp, return max in the end
        int mask = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--)
        {
            mask = mask | (1 << i);

            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++)
            {
                set.add(nums[j] & mask);
            }

            int tmp = max | (1 << i);
            for (int prefix: set)
            {
                if (set.contains(tmp ^ prefix))
                {
                    max = tmp;

                    break;
                }
            }
        }

        return max;
    }
}