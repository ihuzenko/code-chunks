package chunks.book.ch2.queue;

import java.util.Arrays;

import chunks.util.ArrUtil;
import chunks.util.LogUtil;

public class SortOnInsertArrayPriorityQueue<E extends Comparable<E>> implements ItemsPriorityQueue<E> {

  private E[] arr;
  private int size;

  @SuppressWarnings("unchecked")
  public SortOnInsertArrayPriorityQueue() {
    arr = (E[]) new Comparable[10];
  }

  @Override
  public void insert(E e) {
    if (isEmpty()) {
      arr[size++] = e;
      return;
    }
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, (int) (size * 1.5));
    }
    int insertionPos = ArrUtil.detectInsertionIndexUsingBinarySearch(arr, e, size);
    if (insertionPos == size) {
      arr[size] = e;
    } else {
      System.arraycopy(arr, insertionPos, arr, insertionPos + 1, size - insertionPos);
      arr[insertionPos] = e;
    }
    size++;
  }

  @Override
  public E max() {
    return isEmpty() ? null : arr[size - 1];
  }

  @Override
  public E delMax() {
    if (isEmpty()) {
      return null;
    }
    E max = arr[--size];
    arr[size] = null;
    if (size > 0 && size < arr.length / 4) {
      arr = Arrays.copyOf(arr, arr.length / 2);
    }
    return max;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public String toString() {
    return String.format("PQ[size:%d|data:%s]", size(), Arrays.toString(arr));
  }

  public static void main(String[] args) {
    ItemsPriorityQueue<Integer> pq = new SortOnInsertArrayPriorityQueue<>();
    pq.insert(7);
    LogUtil.log(pq);
    pq.insert(1);
    LogUtil.log(pq);
    pq.insert(4);
    LogUtil.log(pq);
    pq.insert(8);
    LogUtil.log(pq);
    pq.insert(5);
    LogUtil.log(pq);
    pq.insert(-1);
    LogUtil.log(pq);
    pq.insert(2);
    LogUtil.log(pq);
    pq.insert(9);
    LogUtil.log(pq);
    pq.insert(10);
    LogUtil.log(pq);
    pq.insert(6);
    LogUtil.log(pq);
    pq.insert(101);
    LogUtil.log(pq);
    LogUtil.log("pop:" + pq.delMax());
    LogUtil.log(pq);
    LogUtil.log("pop:" + pq.delMax());
    LogUtil.log(pq);
    LogUtil.log("pop:" + pq.delMax());
    LogUtil.log(pq);
    LogUtil.log("pop:" + pq.delMax());
    LogUtil.log(pq);
  }
}
