package chunks.book.ch2.sorting;

public class MergeRecursiveTopDown {

  public static void sort(int[] arr) {
    sort(arr, new int[(arr.length / 2) + 1], 0, arr.length - 1);
  }

  private static void sort(int[] arr, int[] leftBuf, int low, int high) {
    if (high <= low) return;
    final int mid = low + (high - low) / 2;
    sort(arr, leftBuf, low, mid);
    sort(arr, leftBuf, mid + 1, high);
    SortUtil.merge(arr, leftBuf, low, mid, high);
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(MergeRecursiveTopDown::sort);
  }
}
