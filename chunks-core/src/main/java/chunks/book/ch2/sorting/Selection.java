package chunks.book.ch2.sorting;

/**
 * One of the simplest sorting algorithms works as follows: First, find
 * the smallest item in the array and exchange it with the first entry (itself if the first entry
 * is already the smallest). Then, find the next smallest item and exchange it with the sec-
 * ond entry. Continue in this way until the entire array is sorted. This method is called
 * selection sort because it works by repeatedly selecting the smallest remaining item.
 */
public class Selection {

  public static void sort(int[] arr) {
    final int loopCount = arr.length - 1;
    for (int outerIdx = 0; outerIdx < loopCount; outerIdx++) {
      // start with current index
      int minIdx = outerIdx;
      // cache min value to make less array accesses
      int min = arr[outerIdx];
      // finding min value index in sub-array from current to end
      for (int innerIdx = outerIdx + 1; innerIdx < arr.length; innerIdx++) {
        if (arr[innerIdx] < min) {
          min = arr[innerIdx];
          minIdx = innerIdx;
        }
      }
      // exchange current and min values
      SortUtil.exchange(arr, outerIdx, minIdx);
    }
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Selection::sort);
  }
}
