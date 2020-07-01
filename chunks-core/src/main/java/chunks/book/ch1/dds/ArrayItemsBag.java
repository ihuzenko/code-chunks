package chunks.book.ch1.dds;

import chunks.util.ArrUtil;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayItemsBag<I> implements ItemsBag<I> {

  private I[] items;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayItemsBag() {
    items = (I[]) new Object[10];
  }

  @Override
  public void add(I itm) {
    if (size == items.length) {
      items = Arrays.copyOf(items, (int) (1.5 * size));
    }
    items[size++] = itm;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<I> iterator() {
    return ArrUtil.arrayIterator(items, size);
  }

  public static void main(String[] args) {
    ItemsBag<Integer> bag = new ArrayItemsBag<>();

    for (int i = 0; i < 1000; i++)
      bag.add(i);

    for (int i : bag)
      System.out.println(i);

  }

}
