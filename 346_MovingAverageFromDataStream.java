class MovingAverage {
	private int size;
	private int currentSize;
	private double sum;
	private int[] nums;
	private int nextIndex;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
		currentSize = 0;
		sum = 0.0;
		nums = new int[size];
		nextIndex = -1;
    }
    
    public double next(int val) {
        if (currentSize < size) {
			sum += (double)val;

			currentSize++;

			nums[++nextIndex] = val;

			return sum / currentSize;
		} else {
			nextIndex = (nextIndex + 1) % size;
			int replace = nums[nextIndex];
			nums[nextIndex] = val;

			sum -= replace;
			sum += (double)val;
		}

		return sum / size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */