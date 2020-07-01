package chunks.book.ch2.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

import chunks.util.ArrUtil;
import chunks.util.LogUtil;

public final class SortUtil {

  private static final Random RAND = new Random();

  private SortUtil() {
  }

  public static void exchange(final int[] arr, final int i, final int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static void assertSorted(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    for (int i = 1; i < arr.length; i++)
      if (arr[i - 1] > arr[i])
        throw new AssertionError(String.format("Passed array is not sorted at indexes [%d] and [%d] found values '%d'>'%d'\n%s",
            i - 1, i, arr[i - 1], arr[i], Arrays.toString(arr)));
    LogUtil.log("Ok, sorted.");
  }

  /**
   * Utility merge method which tries to end merging process as soon as possible.
   *
   * @param arr     original array
   * @param leftBuf may be used to buffer left side
   * @param low     low idx, start of left part
   * @param mid     mid idx included into left part
   * @param high    high idx included into right part
   */
  public static void merge(int[] arr, int[] leftBuf, int low, int mid, int high) {
    int r = mid + 1;
    if (arr[mid] <= arr[r]) {
      // if last element in left array is less than
      // first element in right - merge is done
      return;
    } else if (high - 1 == low) {
      // left and right size is 1 and it's enough to swap in-place
      int tmp = arr[low];
      arr[low] = arr[high];
      arr[high] = tmp;
      return;
    }
    // copy of left part including mid value
    final int leftSize = (mid + 1) - low;
    System.arraycopy(arr, low, leftBuf, 0, leftSize);
    int c, l;
    // c - current index in arr, l - left index in leftBuf copy , r - right index in arr
    for (c = low, l = 0; c <= high; c++) {
      if (l == leftSize) {
        break; // if left side ended then merge completed
      } else if (r > high) {
        // only right side ended, remaining left will be copied back to arr
        if (l == leftSize - 1) {
          // just copy last left element
          arr[high] = leftBuf[l];
        } else {
          System.arraycopy(leftBuf, l, arr, c, leftSize - l);
        }
        break;
      }
      // the locals reduces arr accesses
      int lv = leftBuf[l];
      int rv = arr[r];
      if (lv < rv) {
        // copy from left side
        arr[c] = lv;
        l++;
      } else {
        // copy from right side
        arr[c] = rv;
        r++;
      }
    }
  }

  public static void ensureSortCorrectness(Consumer<int[]> sort) {
    for (int outer = 0; outer <= 100; outer++) {
      int[] arr = new int[outer];
      for (int i = 0; i < outer; i++) {
        arr[i] = RAND.nextInt();
      }
      int[] sortedArr = ArrUtil.sortedCopy(arr);
      sort.accept(arr);
      assertSorted(arr);

      if (!Arrays.equals(arr, sortedArr)) {
        // todo: find elements which didn't match
        throw new AssertionError("Sort didn't preserve elements!");
      }
    }
  }
}