package chunks.book.ch1.dds;

public interface Items<I> extends Iterable<I> {

  int size();

  default boolean isEmpty() {
    return size() == 0;
  }
}
