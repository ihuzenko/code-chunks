package chunks.book.ch2.sorting;

public class MergeIterativeBottomUp {

  public static void sort(int[] arr) {
    final int arrSize = arr.length;
    final int arrSizeMinusOne = arrSize - 1;
    int[] leftBuf = new int[arrSize];
    for (int chunk = 1; chunk < arrSize; chunk *= 2) {
      final int subSize = arrSize - chunk;
      for (int low = 0; low < subSize; low += chunk * 2) {
        int mid = low + chunk - 1;
        int high = Math.min(low + 2 * chunk - 1, arrSizeMinusOne);
        SortUtil.merge(arr, leftBuf, low, mid, high);
      }
    }
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(MergeIterativeBottomUp::sort);
  }
}
