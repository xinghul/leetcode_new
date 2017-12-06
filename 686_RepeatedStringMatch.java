class Solution {
    public int repeatedStringMatch(String A, String B) {
		String repeatedA = A;
		int repeat = 1;
        while (repeatedA.length() < B.length())
		{
			repeatedA += A;
			repeat++;
		}

		if (repeatedA.indexOf(B) != -1) {
			return repeat;
		}

		repeatedA += A;
		repeat++;

		if (repeatedA.indexOf(B) != -1) {
			return repeat;
		}

		return -1;
    }
}