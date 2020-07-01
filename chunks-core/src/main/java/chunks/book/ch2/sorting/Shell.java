package chunks.book.ch2.sorting;

public class Shell {

  public static void sort(int[] arr) {
    for (int gap = computeGapSize(arr.length); gap >= 1; gap /= 3) {
      for (int i = gap; i < arr.length; i++) {
        for (int j = i, jm = j - gap; jm >= 0 && arr[j] < arr[jm]; j -= gap, jm = j - gap) {
          SortUtil.exchange(arr, j, jm);
        }
      }
    }
  }

  private static int computeGapSize(int n) {
    int gapSize = 1;
    n /= 3;
    while (gapSize < n) {
      gapSize = 3 * gapSize + 1;
    }
    return gapSize;
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Shell::sort);
  }
}
