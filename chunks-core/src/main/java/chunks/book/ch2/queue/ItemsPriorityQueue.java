package chunks.book.ch2.queue;

public interface ItemsPriorityQueue<E extends Comparable<E>> {

  void insert(E e);

  E max();

  E delMax();

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }
}
