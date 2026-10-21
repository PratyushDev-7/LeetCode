class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // Pointer for the next position to place a non-zero element

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}