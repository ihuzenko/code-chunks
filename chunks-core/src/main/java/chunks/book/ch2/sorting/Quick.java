package chunks.book.ch2.sorting;

public class Quick {

  public static void sort(int[] arr) {
    sort(arr, 0, arr.length - 1);
  }

  private static void sort(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivotIdx = partition(arr, low, high);
    sort(arr, low, pivotIdx - 1);
    sort(arr, pivotIdx + 1, high);
  }

  private static int partition(int[] arr, int low, int high) {
    final int pivot = arr[high];
    // pivot index after partitioning, or in other words it's fist
    // element greater than pivot before last exchange in the method
    int i = low;
    for (int j = low, tmp; j < high; j++) {
      if ((tmp = arr[j]) < pivot) {
        arr[j] = arr[i];
        arr[i++] = tmp;
      }
    }
    arr[high] = arr[i];
    arr[i] = pivot;
    return i;
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Quick::sort);
  }
}
