class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < (int)Math.pow(2, n); i++)
        {
          List<Integer> tmp = new ArrayList<>();

          for (int j = 0; j < n; j++)
          {
            if ((i & (1 << j)) != 0) {
              tmp.add(nums[j]);
            }
          }

          result.add(tmp);
        }

        return result;
    }
}