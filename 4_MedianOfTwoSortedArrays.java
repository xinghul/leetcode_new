class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length = nums1.length + nums2.length;

		if (length % 2 == 1) {
			return findMedianHelper(nums1, nums2, 0, 0, length / 2 + 1);
		}

        return (findMedianHelper(nums1, nums2, 0, 0, length / 2) + findMedianHelper(nums1, nums2, 0, 0, length / 2 + 1)) / 2;
    }

	private double findMedianHelper(int[] nums1, int[] nums2, int start1, int start2, int k) {

		if (start1 >= nums1.length) {
			return nums2[start2 + k - 1];
		}
		if (start2 >= nums2.length) {
			return nums1[start1 + k - 1];
		}

		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}

		int index1 = start1 + k / 2 - 1;
		int index2 = start2 + k / 2 - 1;

		int value1 = index1 >= nums1.length ? Integer.MAX_VALUE : nums1[index1];
		int value2 = index2 >= nums2.length ? Integer.MAX_VALUE : nums2[index2];

		if (value1 > value2) {
			return findMedianHelper(nums1, nums2, start1, index2 + 1, k - k / 2);
		} else {
			return findMedianHelper(nums1, nums2, index1 + 1, start2, k - k / 2);
		}
	}
}