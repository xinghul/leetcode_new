class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      int size = nums.length;
      for (int i = 0; i < size; i++)
      {
        nums[(nums[i] - 1) % size] += size;
      }

      ArrayList<Integer> result = new ArrayList<>();

      for (int i = 0; i < size; i++)
      {
        if (nums[i] <= size) {
          result.add(i + 1);
        }
      }

      return result;
    }
}