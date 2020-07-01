package chunks.book.ch2.sorting;

/**
 * Classical heap sort consists of two phases:
 * 1) build max heap by continuously sinking first half of the array
 * 2) continuously swap last and first and sink new first in sub-array
 * heap bounded by last, decrement last index before repetition
 */
public class Heap {

  private static void sort(int[] arr) {
    // build max heap from given array
    for (int j = arr.length / 2 - 1; j > -1; j--) {
      sink(arr, j, arr.length);
    }
    // insert highest elements at right positions
    // then reduce heap size and restore it's heap property
    // before next iteration
    for (int last = arr.length - 1; last > -1; last--) {
      SortUtil.exchange(arr, 0, last);
      sink(arr, 0, last);
    }
  }

  private static void sink(final int[] arr, int k, final int size) {
    // j - points to k-th left child at loop start
    // jp - points to right child
    int j, jp;
    while ((j = k * 2 + 1) < size) {
      // check if right child greater than left, and select it if true.
      if ((jp = j + 1) < size && arr[j] < arr[jp]) {
        j = jp;
      }
      // exchange k with greater child or stop sink immediately
      if (arr[k] < arr[j]) {
        SortUtil.exchange(arr, k, j);
        k = j;
      } else {
        break;
      }
    }
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Heap::sort);
  }
}
