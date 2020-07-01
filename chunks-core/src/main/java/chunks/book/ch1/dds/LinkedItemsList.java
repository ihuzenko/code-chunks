package chunks.book.ch1.dds;

import java.util.Iterator;

public class LinkedItemsList<I> implements ItemsList<I> {

  private Node<I> first;
  private Node<I> last;
  private int size;

  @Override
  public void addFirst(I item) {
    size++;
    if (first == null) {
      first = last = new Node<>(item);
    } else {
      first = first.addPrev(item);
    }
  }

  @Override
  public void addLast(I item) {
    size++;
    if (last == null) {
      last = first = new Node<>(item);
    } else {
      last = last.addNext(item);
    }
  }

  @Override
  public void add(int idx, I item) {
    Node<I> prev = getNode(idx - 1);
    if (prev == null) {
      return;
    }
    prev.next = new Node<>(item, prev.next);
  }

  @Override
  public I get(int idx) {
    Node<I> node = getNode(idx);
    return node == null ? null : node.item;
  }

  private Node<I> getNode(int idx) {
    if (idx > -1 && idx < size) {
      Node<I> node = first;
      for (int i = 1; i <= idx; i++)
        node = node.next;
      return node;
    }
    return null;
  }

  @Override
  public I removeFirst() {
    if (first == null)
      return null;
    I removed = first.item;
    if (first == last) {
      first = null;
      last = null;
    } else {
      first = first.next;
    }
    size--;
    return removed;
  }

  @Override
  public I removeLast() {
    if (last == null)
      return null;
    I removed = last.item;
    if (last == first) {
      first = null;
      last = null;
    } else {
      Node<I> node = first;
      while (node.next != last)
        node = node.next;
      last = node;
      last.next = null;
    }
    size--;
    return removed;
  }

  @Override
  public I remove(int idx) {
    if (idx > -1 && idx < size) {
      Node<I> prev = first;
      if (idx == 0) {
        return removeFirst();
      } else if (idx == size - 1) {
        return removeLast();
      }
      for (int i = 0; i < idx; i++) {
        prev = prev.next;
      }
      Node<I> removed = prev.next;
      prev.next = removed.next;
      removed.next = null;
      size--;
      return removed.item;
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<I> iterator() {
    return new LinkedItemsListIterator();
  }

  private class LinkedItemsListIterator implements Iterator<I> {

    private Node<I> node = first;

    @Override
    public boolean hasNext() {
      return node != null;
    }

    @Override
    public I next() {
      I next = node.item;
      node = node.next;
      return next;
    }
  }

  private static <I> LinkedItemsList<I> reverse(LinkedItemsList<I> list) {
    LinkedItemsList<I> reverseList = new LinkedItemsList<>();
    Node<I> node = list.first;
    while (node != null) {
      reverseList.addFirst(node.item);
      node = node.next;
    }
    return reverseList;
  }
}
