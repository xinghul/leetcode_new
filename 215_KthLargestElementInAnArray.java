class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++)
        {
          if (queue.size() < k) {
            queue.add(nums[i]);
          } else {
            if (queue.peek() >= nums[i]) {
              continue;
            } else {
              queue.add(nums[i]);

              queue.poll();
            }
          }
        }

        return queue.peek();
    }
}