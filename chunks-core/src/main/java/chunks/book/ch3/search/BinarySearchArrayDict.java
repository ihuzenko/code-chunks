package chunks.book.ch3.search;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import chunks.util.LogUtil;

public class BinarySearchArrayDict<K extends Comparable<K>, V> implements ComparableKeysDict<K, V> {

  private K[] keys;
  private V[] values;
  private int size;

  @SuppressWarnings("unchecked")
  public BinarySearchArrayDict() {
    keys = (K[]) new Comparable[10];
    values = (V[]) new Object[10];
  }

  @Override
  public K min() {
    return isEmpty() ? null : keys[0];
  }

  @Override
  public K max() {
    return isEmpty() ? null : keys[size - 1];
  }

  @Override
  public K floor(K key) {
    if (key == null || isEmpty())
      return null;
    int i = rank(key);
    return i < size
        ? key.compareTo(keys[i]) == 0 ? key : (i == 0) ? null : keys[i - 1]
        : max();
  }

  @Override
  public K ceil(K key) {
    if (key == null || isEmpty())
      return null;
    int i = rank(key);
    return i < size
        ? keys[i]
        : null;
  }

  @Override
  public int rank(final K key) {
    int low = 0;
    for (int high = size - 1; low <= high; ) {
      int mid = low + (high - low) / 2;
      int comparisonResult = key.compareTo(keys[mid]);
      if (comparisonResult < 0) {
        high = mid - 1;
      } else if (comparisonResult > 0) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return low;
  }

  @Override
  public K select(int rank) {
    return keys[rank];
  }

  @Override
  public Iterable<K> keys(K low, K high) {
    int rankLow = rank(low);
    int rankHigh = rank(high);
    Queue<K> q = new ArrayDeque<>(Arrays.asList(keys).subList(rankLow, rankHigh));
    if (has(high))
      q.add(high);
    return q;
  }

  @Override
  public V put(K key, V val) {
    if (key == null) {
      return null;
    }
    int rank = rank(key);
    // resizing
    if (size == keys.length) {
      keys = Arrays.copyOf(keys, size * 2);
      values = Arrays.copyOf(values, size * 2);
    }

    if (rank < size) {
      if (key.compareTo(keys[rank]) == 0) {
        V oldValue = values[rank];
        values[rank] = val;
        return oldValue;
      } else {
        System.arraycopy(keys, rank, keys, rank + 1, size + 1 - rank);
        System.arraycopy(values, rank, values, rank + 1, size + 1 - rank);
        keys[rank] = key;
        values[rank] = val;
        size++;
      }
    } else {
      keys[size] = key;
      values[size++] = val;
    }
    return null;
  }

  @Override
  public V get(K key) {
    final int r = rank(key);
    if (r < size && keys[r].compareTo(key) == 0) {
      return values[r];
    }
    return null;
  }

  @Override
  public V del(K key) {
    if (key == null || isEmpty()) {
      return null;
    }
    final int i = rank(key);
    if (i < size && key.compareTo(keys[i]) == 0) {
      // found, need to remove
      V old = values[i];
      keys[i] = null;
      values[i] = null;
      if (i != --size) {
        int start = i + 1;
        int remaining = size - i;
        System.arraycopy(keys, start, keys, i, remaining);
        System.arraycopy(values, start, values, i, remaining);
        keys[size] = null;
        values[size] = null;
      }
      return old;
    }
    return null; // not found
  }

  @Override
  public int size() {
    return size;
  }


  public static void main(String[] args) {
    ComparableKeysDict<Integer, String> t = new BinarySearchArrayDict<>();

    t.put(9, "Nine");
    t.put(7, "Seven");
    t.put(5, "Five");
    t.put(3, "Three");
    t.put(1, "One");

    t.put(2, "Two");
    t.put(6, "Six");
    t.put(8, "Eight");
    t.put(10, "Ten");

    LogUtil.log("\n---get---");
    LogUtil.log(t.get(-1));
    LogUtil.log(t.get(1));
    LogUtil.log(t.get(7));
    LogUtil.log(t.get(11));


    LogUtil.log("\n---floor---");
    LogUtil.log(t.floor(8));
    LogUtil.log(t.floor(20));
    LogUtil.log(t.floor(-1));
    LogUtil.log(t.floor(4));

    LogUtil.log("\n---ceil---");
    LogUtil.log(t.ceil(8));
    LogUtil.log(t.ceil(20));
    LogUtil.log(t.ceil(-1));
    LogUtil.log(t.ceil(4));

    LogUtil.log("\n---keys(3,7)---");
    for (Integer i : t.keys(3, 7)) {
      LogUtil.log(i);
    }

    LogUtil.log("\n---del(2)---");
    LogUtil.log(t.del(2));
    LogUtil.log(t.del(t.min()));
    LogUtil.log(t.del(t.max()));
    LogUtil.log(t);

  }
}
