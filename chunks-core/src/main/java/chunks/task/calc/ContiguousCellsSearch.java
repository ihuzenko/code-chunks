package chunks.task.calc;

import static chunks.util.LogUtil.log;

/**
 * Solution for Task:
 * <p>
 * Finding the max length of connected cells of 1s (regions) in an matrix of Os and 1s.
 * <p>
 * For example, for given matrix
 * 1 1 0 1
 * 1 1 0 1
 * 0 0 0 1
 * 0 1 1 1
 * <p>
 * 6 is size of max connected 1s region.
 */
public class ContiguousCellsSearch {

  /**
   * Offsets for getting neighbour elements indexes. For example
   * current i and j index points to 'o', then using this offsets
   * indexes of all 'x' cells can be calculated:
   * |x|x|x|
   * |x|o|x|
   * |x|x|x|
   */
  private static final int[] OFFSETS = new int[]{
      -1, -1, // top left cell
      -1, 0,  // top mid cell
      -1, 1,  // top right cell

      0, 1,  // right cell

      1, 1,  // down right cell
      1, 0,  // down mid cell
      1, -1, // down left cell

      0, -1  // left cell
  };


  public static int getMaxSizeOfContiguousUnits(int[][] mx) {
    int max = 0;
    boolean[][] isChecked = new boolean[mx.length][mx[0].length];
    for (int i = 0; i < mx.length; i++) {
      for (int j = 0; j < mx[0].length; j++) {
        if (isChecked[i][j]) {
          continue;
        }
        int localMax = getMaxRecursive(mx, isChecked, i, j, 0);
        if (localMax > max) {
          max = localMax;
        }
      }
    }
    return max;
  }


  private static int getMaxRecursive(int[][] mx, boolean[][] checked,
                                     int i, int j,
                                     int max) {
    log("(%d,%d)->v=%d", i, j, max);
    // check accepted value
    checked[i][j] = true;

    // increase current value
    if (mx[i][j] == 1) {
      max++;
    }

    // loop used to check all neighbour cells
    for (int oi = 0, oj = 1; oj < OFFSETS.length; oi += 2, oj += 2) {
      int ni = i + OFFSETS[oi];
      if (badNi(mx, ni)) {
        continue;
      }
      int nj = j + OFFSETS[oj];
      if (badNj(mx, nj) || checked[ni][nj]) {
        continue;
      }

      if (mx[ni][nj] == 0) {
        checked[ni][nj] = true;
      } else {
        max = getMaxRecursive(mx, checked, ni, nj, max);
      }
    }
    return max;
  }

  private static boolean badNj(int[][] mx, int nj) {
    return nj < 0 || nj >= mx[0].length;
  }

  private static boolean badNi(int[][] mx, int ni) {
    return ni < 0 || ni >= mx.length;
  }

}
