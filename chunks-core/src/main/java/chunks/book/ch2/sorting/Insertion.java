package chunks.book.ch2.sorting;

/**
 * The algorithm that people often use to sort bridge hands is to con-
 * sider the cards one at a time, inserting each into its proper place among those already
 * considered (keeping them sorted). In a computer implementation, we need to make
 * space to insert the current item by moving larger items one position to the right, before
 * inserting the current item into the vacated position.
 */
public class Insertion {

  public static void sort(int[] arr) {
    // start from second index in arr
    for (int currentIdx = 1; currentIdx < arr.length; currentIdx++) {
      // compare elements starting from current and moving to the left side
      // do swap on every success to move item to it's position.
      // in my opinion it's same analogy as bubble but in reverse order
      for (int j = currentIdx; j > 0 && arr[j] < arr[j - 1]; j--) {
        SortUtil.exchange(arr, j, j - 1);
      }
    }
  }

  public static void main(String[] args) {
    SortUtil.ensureSortCorrectness(Insertion::sort);
  }
}