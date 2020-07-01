package chunks.task.calc;

import static chunks.util.LogUtil.log;

public class Matrix {

  public static int[][] transposition(int[][] mx) {
    if (mx == null || mx.length == 0) return new int[0][];
    final int rowCount = mx.length;
    final int colCount = mx[0].length;
    int[][] resMx = new int[colCount][rowCount];
    for (int r = 0; r < rowCount; r++) {
      for (int c = 0; c < colCount; c++) {
        resMx[c][r] = mx[r][c];
      }
    }
    return resMx;
  }

  public static void main(String[] args) {
    int[][] mx = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
    };
    log("Transposition input: ");
    log(mx);
    log("Transposition output: ");
    log(transposition(mx));
  }
}
