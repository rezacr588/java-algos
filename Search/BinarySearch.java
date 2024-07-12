public class BinarySearch {

  // Method to perform binary search
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2; // To prevent overflow
      System.err.println("mid: " + mid);
      System.out.println("low: " + low);
      System.out.println("high: " + high);
      if (arr[mid] == target) {
        return mid; // Target value found at index mid
      } else if (arr[mid] < target) {
        low = mid + 1; // Target is in the upper half
      } else {
        high = mid - 1; // Target is in the lower half
      }
    }

    return -1; // Target value not found
  }

  public static void main(String[] args) {
    int[] sortedArray = { 2, 3, 4, 10, 40 };
    int target = 323;
    int result = binarySearch(sortedArray, target);

    if (result == -1) {
      System.out.println("Element not present in the array.");
    } else {
      System.out.println("Element found at index " + result);
    }
  }
}
