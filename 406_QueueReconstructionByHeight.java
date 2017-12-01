class Solution {
    public int[][] reconstructQueue(int[][] people) {
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
          @Override
          public int compare(int[] value1, int[] value2) {
            if (value1[0] > value2[0]) {
                return -1;
            } else if (value1[0] == value2[0]) {
                if (value1[1] > value2[1]) {
                    return 1;
                } else if (value1[1] < value2[1]) {
                    return -1;
                }

                return 0;
            } else {
                return 1;
            }
          }
        });

        for (int i = 0; i < people.length; i++)
        {
            set.add(people[i]);
        }

        ArrayList<int[]> tmp = new ArrayList<>();
        for (int[] person: set) {
            tmp.add(person[1], person);
        }

        int[][] result = new int[tmp.size()][];
        for (int i = 0; i < tmp.size(); i++)
        {
            result[i] = tmp.get(i);
        }

        return result;
    }
}