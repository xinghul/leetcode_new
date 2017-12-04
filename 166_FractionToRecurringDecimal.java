class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = false;
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
          isNegative = true;
        }

        long lN = Math.abs((long)numerator);
        long lD = Math.abs((long)denominator);

        long before = lN / lD;
        long reminder = lN % lD;

        if (reminder == 0) {
          if (isNegative) {
            return "-" + Long.toString(before);
          }

          return Long.toString(before);
        }

        List<Long> digits = new ArrayList<>();
        List<Long> reminders = new ArrayList<>();
        String result = before + ".";

        reminders.add(reminder);

        boolean recurring = false;
        while (reminder != 0)
        {
          reminder *= 10;
          before = reminder / lD;

          digits.add(before);
          
          reminder = reminder % lD;

          if (reminders.contains(reminder)) {
            recurring = true;

            break;
          }

          if (reminder != 0) {
            reminders.add(reminder);
          }
        }

        if (!recurring) {
          for (long i: digits)
          {
            result += i;
          }
        } else {
          int index = reminders.indexOf(reminder);

          for (int i = 0; i < index; i++)
          {
            result += digits.get(i);
          }

          result += "(";
          for (int i = index; i < digits.size(); i++)
          {
            result += digits.get(i);
          }
          result += ")";
        }

        if (isNegative) {
          return "-" + result;
        }

        return result;
    }
}