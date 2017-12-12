class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3) {
          return result;
        }

        Arrays.sort(nums);

        for (int last = 2; last < nums.length; last++)
        {
          int low = 0, high = last - 1;

          while (low < high)
          {
            int sum = nums[low] + nums[high] + nums[last];

            if (sum == 0) {
              List<Integer> list = Arrays.asList(nums[low], nums[high], nums[last]);
              set.add(list);

              while (low < nums.length - 1 && nums[low] == nums[low + 1])
              {
                low++;
              }
              while (high > 0 && nums[high] == nums[high - 1])
              {
                high--;
              }

              low++;
              high--;
            } else if (sum > 0) {
              high--;
            } else {
              low++;
            }
          }
        }

        result.addAll(set);

        return result;
    }
}