package chunks.util;

import java.util.Arrays;

/**
 * Don't see reason to use logger and introduce additional
 * dependencies for now. Just encapsulated println statements here.
 */
public final class LogUtil {

  private LogUtil() {
  }

  public static void log(Object obj) {
    System.out.println(obj);
  }

  public static void log(Object[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static void log(int[] arr) {
    System.out.println(Arrays.toString(arr));
  }

  public static void log(String str) {
    System.out.println(str);
  }

  public static void log(String f, Object... args) {
    System.out.printf(f + "\n", args);
  }

  public static void log(int i) {
    System.out.println(i);
  }

  public static void log(double d) {
    System.out.println(d);
  }

  public static void log(int[][] mx) {
    for (int[] row : mx) {
      log(row);
    }
  }
}
