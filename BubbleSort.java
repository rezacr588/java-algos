public class BubbleSort {

  // Method to perform Bubble Sort
  public static void bubbleSort(int[] arr) {
    int n = arr.length;
    boolean swapped;

    // Loop through the array
    for (int i = 0; i < n - 1; i++) {
      swapped = false;

      // Inner loop for each pass
      for (int j = 0; j < n - i - 1; j++) {
        // Swap if the element found is greater than the next element
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j + 1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;

          // Set swapped to true
          swapped = true;
        }
      }

      // If no elements were swapped, the array is already sorted
      if (!swapped)
        break;
    }
  }

  // Method to print the array
  public static void printArray(int[] arr) {
    for (int value : arr) {
      System.out.print(value + " ");
    }
    System.out.println();
  }

  // Main method to test the Bubble Sort
  public static void main(String[] args) {
    int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

    System.out.println("Unsorted array:");
    printArray(arr);

    bubbleSort(arr);

    System.out.println("Sorted array:");
    printArray(arr);
  }
}
