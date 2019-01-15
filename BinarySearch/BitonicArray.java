public class Solution {
  public int search(int[] array, int target) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return -1;
    }
    int peak = findBitonicPoint(array);
    int increasing = searchIncreasing(array, 0, peak, target);
    if (increasing != -1) {
      return increasing;
    } else {
      return searchDecreasing(array, peak, array.length - 1, target);
    }
  }
  
  private int findBitonicPoint(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < array[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
  
  private int searchIncreasing(int[] array, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
  
  private int searchDecreasing(int[] array, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
