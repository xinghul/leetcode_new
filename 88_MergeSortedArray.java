class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= n; i--)
        {
          nums1[i] = nums[i - n];
        }

        int index = 0;
        // for nums1
        int i = n;
        // for nums2
        int j = 0;

        while (i < m + n && j < n)
        {
          if (i >= m + n) {
            nums1[index] = nums2[j++];
          } else if (j >= n) {
            nums1[index] = nums1[i++];
          } else if (nums1[i] < nums2[j]) {
            nums1[index] = nums1[i++];
          } else {
            nums1[index] = nums2[j++];
          }

          index++;
        }
    }
}