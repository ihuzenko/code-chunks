package chunks.book.ch1.dds;

public interface ItemsList<I> extends Items<I> {
  void addFirst(I item);
  void addLast(I item);
  void add(int idx, I item);
  I get(int idx);
  I removeFirst();
  I removeLast();
  I remove(int idx);
}
