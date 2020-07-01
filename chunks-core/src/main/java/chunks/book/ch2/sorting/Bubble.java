package chunks.book.ch2.sorting;

public class Bubble {

  public static void sort(int[] arr) {
    boolean isSwapped = true;
    for (int n = arr.length; isSwapped; n--) {
      isSwapped = false;
      for (int i = 0, j = 1; j < n; i++, j++) {
        if (arr[i] > arr[j]) {
          SortUtil.exchange(arr, i, j);
          isSwapped = true;
        }
      }
    }
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Bubble::sort);
  }
}
