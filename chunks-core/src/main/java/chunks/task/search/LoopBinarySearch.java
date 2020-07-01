package chunks.task.search;

import static chunks.util.LogUtil.log;

public class LoopBinarySearch {

  public static int indexOf(int[] arr, int val) {
    int lo = 0, hi = arr.length - 1;
    log(val + " ?");
    String move = "  ";
    while (lo <= hi) {
      int mid = (lo + hi) / 2;
      int midVal = arr[mid];
      log("%s(%d+%d)/2=%d    -> %d == %d ? [%s]", move, lo, hi, mid, midVal, val, (val == midVal) ? "yes" : "no");
      if (val < midVal) {
        move = "<<";
        hi = mid - 1; // move to left
      } else if (val > midVal) {
        move = ">>";
        lo = mid + 1;// move to right
      } else {
        return mid; // found
      }
    }
    log("Not found.");
    return -1; // not found
  }

  public static void main(String[] args) {
    sampleSearches();
  }

  private static void sampleSearches() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    indexOf(arr, 5);
    log("----------------------------");
    indexOf(arr, 10);
    log("----------------------------");
    indexOf(arr, 8);
    log("----------------------------");
    indexOf(arr, 1);
    log("----------------------------");
    indexOf(arr, 20);
    log("----------------------------");
    indexOf(arr, 4);
  }
}
