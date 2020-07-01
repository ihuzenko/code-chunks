package chunks.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public final class ArrUtil {

  private ArrUtil() {
  }

  public static int[] sortedCopy(int[] arr) {
    int[] sorted = Arrays.copyOf(arr, arr.length);
    Arrays.sort(sorted);
    return sorted;
  }

  public static <E extends Comparable<E>> int detectInsertionIndexUsingBinarySearch(E[] arr, E e, int size) {
    int low = 0, high = size - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      if (e.compareTo(arr[mid]) < 0) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static <I> Iterator<I> arrayIterator(I[] array, int size) {
    return new ArrayIterator<>(array, size);
  }

  public static <I> Iterator<I> arrayReverseIterator(I[] array, int size) {
    return new ReverseArrayIterator<>(array, size);
  }

  public static int[] indexed(int size) {
    int[] arr = new int[size];
    for (int i = 0; i<size; i++)
      arr[i] = i;
    return arr;
  }

  public static int[] shuffled(int[] arr) {
    Random r = new Random();
    for (int i = 0, ri = r.nextInt(arr.length); i < arr.length; i++, ri = r.nextInt(arr.length)) {
      int tmp = arr[i];
      arr[i] = arr[ri];
      arr[ri] = tmp;
    }
    return arr;
  }

  private static class ArrayIterator<I> implements Iterator<I> {

    private int idx;
    private final I[] items;
    private final int size;

    private ArrayIterator(I[] items, int size) {
      this.items = items;
      this.size = size;
    }

    public boolean hasNext() {
      return idx < size;
    }

    public I next() {
      return items[idx++];
    }
  }

  private static class ReverseArrayIterator<I> implements Iterator<I> {

    private int idx;
    private final I[] items;

    private ReverseArrayIterator(I[] items, int size) {
      this.items = items;
      this.idx = size;
    }

    public boolean hasNext() {
      return idx > 0;
    }

    public I next() {
      return items[--idx];
    }
  }
}
