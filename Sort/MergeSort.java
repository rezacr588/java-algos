package Sort;

public class MergeSort {

  // Main function that sorts an array using merge sort
  public static void mergeSort(int[] arr) {
    if (arr.length > 1) {
      // Find the middle point to divide the array into two halves
      int mid = arr.length / 2;

      // Create two subarrays from the main array
      int[] leftHalf = new int[mid];
      int[] rightHalf = new int[arr.length - mid];

      // Copy data to the subarrays
      System.arraycopy(arr, 0, leftHalf, 0, mid);
      System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

      for (int num : leftHalf) {
        System.out.print(num + " ");
      }

      System.out.println();

      for (int num : rightHalf) {
        System.out.print(num + " ");
      }

      System.out.println();
      // Recursively sort the two halves
      mergeSort(leftHalf);
      mergeSort(rightHalf);

      // Merge the sorted halves
      merge(arr, leftHalf, rightHalf);
    }
  }

  // Helper function to merge two sorted arrays into a single sorted array
  private static void merge(int[] arr, int[] leftHalf, int[] rightHalf) {
    int i = 0; // Initial index of left subarray
    int j = 0; // Initial index of right subarray
    int k = 0; // Initial index of the merged array

    for (int num : leftHalf) {
      System.out.print(num + " ");
    }

    System.out.println();

    for (int num : rightHalf) {
      System.out.print(num + " ");
    }

    System.out.println();
    // Merge the two arrays into arr
    while (i < leftHalf.length && j < rightHalf.length) {
      if (leftHalf[i] <= rightHalf[j]) {
        arr[k] = leftHalf[i];
        i++;
      } else {
        arr[k] = rightHalf[j];
        j++;
      }
      k++;
    }

    // Copy any remaining elements of leftHalf (if any)
    while (i < leftHalf.length) {
      arr[k] = leftHalf[i];
      i++;
      k++;
    }

    // Copy any remaining elements of rightHalf (if any)
    while (j < rightHalf.length) {
      arr[k] = rightHalf[j];
      j++;
      k++;
    }
  }

  // Main method to test the merge sort algorithm
  public static void main(String[] args) {
    int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

    // Print the original array
    System.out.println("Original array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();

    // Call mergeSort to sort the array
    mergeSort(arr);

    // Print the sorted array
    System.out.println("Sorted array:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
