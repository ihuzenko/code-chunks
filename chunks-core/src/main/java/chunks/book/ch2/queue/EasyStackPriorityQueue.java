package chunks.book.ch2.queue;

import chunks.book.ch1.dds.ArrayItemsStack;

public class EasyStackPriorityQueue<E extends Comparable<E>> extends ArrayItemsStack<E> implements ItemsPriorityQueue<E> {

  @Override
  public void insert(E e) {
    push(e);
  }

  @Override
  public E max() {
    if (isEmpty())
      return null;
    return items[getMaxIdx()];
  }

  @Override
  public E delMax() {
    if (isEmpty())
      return null;
    int lastIdx = size() - 1;
    int maxIdx = getMaxIdx();
    E last = items[lastIdx];
    items[lastIdx] = items[maxIdx];
    items[maxIdx] = last;
    return pop();
  }

  private int getMaxIdx() {
    int maxIdx = 0;
    E m = items[maxIdx];
    for (int i = 1; i < size(); i++) {
      if (m.compareTo(items[i]) < 0) {
        maxIdx = i;
        m = items[maxIdx];
      }
    }
    return maxIdx;
  }


  @Override
  public boolean isEmpty() {
    return size() == 0;
  }
}
