class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<List<Integer>>> twoSum = new HashMap<>();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
        {
          for (int j = 0; j < i; j++)
          {
            int sum = nums[i] + nums[j];
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[j]);
            tmp.add(nums[i]);

            if (twoSum.containsKey(sum)) {
              List<List<Integer>> list = twoSum.get(sum);

              boolean exists = false;
              for (List<Integer> sub: list)
              {
                if (sub.get(0) == tmp.get(0) && sub.get(1) == tmp.get(1)) {
                  exists = true;

                  break;
                }
              }

              if (!exists) {
                list.add(tmp);
              }
            } else {
              List<List<Integer>> list = new ArrayList<>();

              list.add(tmp);

              twoSum.put(sum, list);
            }
          }

          if (twoSum.containsKey(-nums[i])) {
            List<List<Integer>> list = twoSum.get(-nums[i]);

            for (List<Integer> tmp: list)
            {
              List<Integer> newList = new ArrayList(tmp);
              newList.add(nums[i]);

              String str = "";
              for (int num: newList)
              {
                str += num + " ";
              }

              if (!set.contains(str)) {
                result.add(newList);

                set.add(str);
              }
            }
          }
        }

        return result;
    }
}