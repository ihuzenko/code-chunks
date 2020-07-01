package chunks.book.ch1.dds;

public interface ItemsQueue<I> extends Iterable<I> {
  void enqueue(I itm);
  I dequeue();
}
