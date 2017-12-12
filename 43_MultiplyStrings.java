class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--)
        {
          for (int j = num2.length() - 1; j >= 0; j--)
          {
            int val1 = Character.getNumericValue(num1.charAt(i));
            int val2 = Character.getNumericValue(num2.charAt(j));
            int p1 = i + j;
            int p2 = i + j + 1;
            int sum = val1 * val2 + result[p2];            

            result[p1] += sum / 10;
            result[p2] = sum % 10;
          }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit: result)
        {
          if (digit == 0 && sb.length() == 0) {
            continue;
          }

          sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}