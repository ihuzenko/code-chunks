package chunks.book.ch2.queue;

import chunks.util.LogUtil;

public class ArrayHeapPriorityQueue<E extends Comparable<E>> implements ItemsPriorityQueue<E> {

  /*
    [0,    1, 2, 3, 4, 5, 6, 7]
    [null, 9, 7, 6, 4, 5, 3, 1]
                9           1         0
              7  6          2,3       1
             4 5 3 1        4,5,6,7   2
   */
  private E[] heap;
  //not as usual size, because data in heap always starts from index 1
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayHeapPriorityQueue(int max) {
    heap = (E[]) new Comparable[max + 1];
  }

  @Override
  public void insert(E e) {
    heap[++size] = e;
    swim(size);
  }

  @Override
  public E max() {
    return heap[1];
  }

  @Override
  public E delMax() {
    exchange(1, size);
    E max = heap[size];
    heap[size--] = null;
    sink(1);
    return max;
  }

  @Override
  public int size() {
    return size;
  }

  private boolean lessThan(int i, int j) {
    return heap[i].compareTo(heap[j]) < 0;
  }

  private void swim(int k) {
    int half; // points to parent
    // while not root and parent less than child - exchange child and parent
    while (k > 1 && lessThan((half = k >>> 1), k)) {
      exchange(half, k);
      k = half;
    }
  }

  private void sink(int k) {
    int child;
    while ((child = 2 * k) <= size) {
      if (child < size
          && lessThan(child, child + 1)) {
        child++;
      }
      if (lessThan(k, child)) {
        exchange(k, child);
        k = child;
      } else {
        break;
      }
    }
  }

  private void exchange(int i, int j) {
    E e = heap[i];
    heap[i] = heap[j];
    heap[j] = e;
  }

  @Override
  public String toString() {
    if (size == 0) return "";
    StringBuilder sb = new StringBuilder().append(heap[1]);
    for (int k = 2, lvlMax = 4; k <= size; k *= 2, lvlMax *= 2) {
      sb.append("\n");
      for (int j = k; j < lvlMax && j <= size; j++) // for each element on level
        sb.append(heap[j]).append("   ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ItemsPriorityQueue<Integer> pq = new ArrayHeapPriorityQueue<>(20);
    for (int i = 1; i < 21; i++) {
      pq.insert(i);
    }
    LogUtil.log(pq);
  }

}