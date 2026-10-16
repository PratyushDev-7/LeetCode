class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // Points to the last unique element found

        // Iterate through the array with a second pointer 'j'
        for (int j = 1; j < nums.length; j++) {
            // If we find a new unique element
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Move it to the next unique position
            }
        }

        // Return the count of unique elements (index + 1)
        return i + 1;
    }
}