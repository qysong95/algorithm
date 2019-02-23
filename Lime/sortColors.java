class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;
        while (white <= blue) {
            if (nums[white] == 0) {
                swap(nums, red++, white++);
            } else if (nums[white] == 1) {
                white++;
            } else {
                swap(nums, white, blue--);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
1. use three pointers to apart from three colors
    - red: the left hand side of the red index (not including red) have been processed and should be kept in red color ----> [0, red)
    - white: the left hand side of the white (not including white) and the right hand side of the red (including red) is in white color -----> [red, white)
    - blue: the right hand side of blue (not including blue) have been processed and should be kept in blue color ----> (blue, nums.length - 1]
    - [white, blue] is the area not been processed.
    
2. initial state:
    - red = 0
    - white = 0
    - blue = nums.length - 1

3. algorithm:
    - if nums[white] == 0, swap(red, white), red++, white++
    - if nums[white] == 1, white++
    - if nums[white] == 2, swap(white, blue), blue--
    - when white > blue, end algorithm

4. complexity:
    - time: linear scan, O(n)
    - space: three pointers, O(1)
*/
