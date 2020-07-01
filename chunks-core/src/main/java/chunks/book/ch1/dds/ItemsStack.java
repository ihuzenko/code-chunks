package chunks.book.ch1.dds;

public interface ItemsStack<I> extends Items<I> {
  void push(I itm);
  I pop();
}
