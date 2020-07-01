package chunks.book.benchmark;

import java.util.Arrays;
import java.util.Random;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
public class SortState {

  private static final Random R = new Random();

  private int[] worst_100_000;
  private int[] worst_1_000_000;

  private int[] best_100_000;
  private int[] best_1_000_000;

  private int[] random_100_000;
  private int[] random_1_000_000;


  @Setup
  public void setup() {
    worst_100_000 = fillWorst(new int[100_000]);
    worst_1_000_000 = fillWorst(new int[1_000_000]);
    best_100_000 = fillBest(new int[100_000]);
    best_1_000_000 = fillBest(new int[1_000_000]);
    random_100_000 = fillRandom(new int[100_000]);
    random_1_000_000 = fillRandom(new int[1_000_000]);
  }

  @TearDown
  public void teardown() {
    worst_100_000 = null;
    worst_1_000_000 = null;
    best_100_000 = null;
    best_1_000_000 = null;
    random_100_000 = null;
    random_1_000_000 = null;
  }

  int[] getWorst_100_000() {
    return copy(worst_100_000);
  }

  int[] getWorst_1_000_000() {
    return copy(worst_1_000_000);
  }

  int[] getBest_100_000() {
    return copy(best_100_000);
  }

  int[] getBest_1_000_000() {
    return best_1_000_000;
  }

  int[] getRandom_100_000() {
    return copy(random_100_000);
  }

  int[] getRandom_1_000_000() {
    return copy(random_1_000_000);
  }

  private static int[] fillWorst(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr.length - i;
    }
    return arr;
  }

  private static int[] fillBest(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  private static int[] fillRandom(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = R.nextInt();
    }
    return arr;
  }

  private static int[] copy(int[] arr) {
    return Arrays.copyOf(arr, arr.length);
  }
}
