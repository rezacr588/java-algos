package Sort;

public class SelectionSort {
  public static void main(String[] args) {
    int[] array = { 64, 25, 12, 22, 11 };
    selectionSort(array);
    System.out.println("Sorted array:");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
  }

  public static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      System.out.println("Minimum element: " + arr[minIndex]);
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
      System.out.println("Swapping " + arr[minIndex] + " and " + arr[i]);
      for (int k = 0; k < arr.length; k++) {
        System.out.print(arr[k] + " ");
      }
    }
  }
}
