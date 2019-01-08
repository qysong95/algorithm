/*
* Assume array is not null
* Assume k >= 0, and k smaller than array.length
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                right = mid + 1;
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            if (right >= arr.length || left >= 0 && x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        if (left < 0 || right < arr.length && x - arr[left] > arr[right] - x) {
            left++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[left + i]);
        }
        return result;
    }
}
