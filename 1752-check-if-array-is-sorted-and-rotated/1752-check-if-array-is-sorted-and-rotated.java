class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Iterate through each element and compare with the next (including wrap-around)
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // A valid sorted and rotated array can have at most one drop point
        return count <= 1;
    }
}