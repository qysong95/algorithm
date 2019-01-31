package leetcode;

public class Solution {
	
	public String shuffle(String input) {
	    if (input == null) {
	        return input;
	    }
	    char[] array = input.toCharArray();
	    helper(array, 0, array.length - 1);
	    return new String(array, 0, array.length);
	}

	private void helper(char[] array, int left, int right) {
	    int size = right - left + 1;
	    if (size <= 2) {
	        return;
	    }
	    int mid = left + size / 2;
	    int lmid = left + size / 4;
	    int rmid = mid + size / 4;
	    reverse(array, lmid, mid - 1);
	    reverse(array, mid, rmid - 1);
	    reverse(array, lmid, rmid - 1);
	    helper(array, left, left + (lmid - left) * 2 - 1);
	    helper(array, left + (lmid - left) * 2, right);
	}

	private void reverse(char[] array, int left, int right) {
	    while (left < right) {
	        char temp = array[left];
	        array[left] = array[right];
	        array[right] = temp;
	        left++;
	        right--;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().shuffle("ABCD1234"));
	}

}
