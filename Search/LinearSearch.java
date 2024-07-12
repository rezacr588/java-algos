public class LinearSearch {
  public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i; // Return the index of the target element
      }
    }
    return -1; // Return -1 if the target element is not found
  }

  public static void main(String[] args) {
    int[] numbers = { 4, 2, 7, 1, 9, 3 };
    int target = 123;

    int result = linearSearch(numbers, target);

    if (result != -1) {
      System.out.println("Element found at index: " + result);
    } else {
      System.out.println("Element not found in the array");
    }
  }
}
