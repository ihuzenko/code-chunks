package chunks.book.ch1.dds;

import java.util.Iterator;

public class LinkedListQueue<I> implements ItemsQueue<I> {

  private final ItemsList<I> q = new LinkedItemsList<>();

  @Override
  public void enqueue(I itm) {
    q.addLast(itm);
  }

  @Override
  public I dequeue() {
    return q.removeFirst();
  }

  @Override
  public Iterator<I> iterator() {
    return q.iterator();
  }
}
