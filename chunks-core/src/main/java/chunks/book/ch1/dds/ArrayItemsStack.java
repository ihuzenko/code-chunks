package chunks.book.ch1.dds;

import chunks.util.ArrUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayItemsStack<I> implements ItemsStack<I> {

  protected I[] items;
  private int size;

  @SuppressWarnings("unchecked")
  public ArrayItemsStack() {
    items = (I[]) new Object[10];
  }

  @Override
  public void push(I itm) {
    if (size == items.length) {
      items = Arrays.copyOf(items, size * 2);
    }
    items[size++] = itm;
  }

  @Override
  public I pop() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack is empty.");
    }
    I itm = items[--size];
    items[size] = null;
    if (size > 0 && size < items.length / 4)
      items = Arrays.copyOf(items, items.length / 2);
    return itm;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<I> iterator() {
    return ArrUtil.arrayReverseIterator(items, size);
  }

}
