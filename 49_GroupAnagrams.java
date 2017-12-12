class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs)
        {
          char[] chs = str.toCharArray();
          Arrays.sort(chs);
          String sortedStr = new String(chs);

          if (map.containsKey(sortedStr)) {
            List<String> list = map.get(sortedStr);

            list.add(str);
          } else {
            List<String> list = new ArrayList<>();
            list.add(str);

            map.put(sortedStr, list);
          }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> list: map.values())
        {
          result.add(list);
        }

        return result;
    }
}