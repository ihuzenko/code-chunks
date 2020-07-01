package chunks.book.ch3.search;


import java.util.Iterator;

import chunks.util.LogUtil;

public class LinearSearchDict<K, V> implements Dict<K, V> {

  private int size;
  private Node<K, V> root;

  @Override
  public V put(K key, V val) {
    if (key == null) {
      return null;
    }
    // try to replace existing value for the key
    for (Node<K, V> n = root; n != null; n = n.nxt) {
      if (key.equals(n.k)) {
        V oldVal = n.v;
        n.v = val;
        return oldVal;
      }
    }
    // new key
    size++;
    root = Node.of(key, val, root);
    return null;
  }

  @Override
  public V get(K key) {
    if (key == null) {
      return null;
    }
    for (Node<K, V> n = root; n != null; n = n.nxt) {
      if (key.equals(n.k))
        return n.v;
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterable<K> keys() {
    return () -> new Iterator<K>() {
      Node<K, V> n = root;

      @Override
      public boolean hasNext() {
        return n != null;
      }

      @Override
      public K next() {
        K k = n.k;
        n = n.nxt;
        return k;
      }
    };
  }

  @Override
  public V del(K key) {
    if (key == null || isEmpty()) {
      return null;
    }
    if (key.equals(root.k)) {
      V deleted = root.v;
      root = root.nxt;
      size--;
      return deleted;
    }
    for (Node<K, V> n = root; n.nxt != null; n = n.nxt) {
      if (key.equals(n.nxt.k)) {
        V deleted = n.nxt.v;
        n.nxt = n.nxt.nxt;
        size--;
        return deleted;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("size:").append(size).append("\n");
    for (Node<K, V> n = root; n != null; n = n.nxt)
      sb.append(n).append(" -> ");
    return sb.toString();
  }

  private static final class Node<K, V> {

    final K k;
    V v;
    Node<K, V> nxt;

    Node(K k, V v, Node<K, V> nxt) {
      this.k = k;
      this.v = v;
      this.nxt = nxt;
    }

    static <K, V> Node<K, V> of(K k, V v, Node<K, V> n) {
      return new Node<>(k, v, n);
    }

    @Override
    public String toString() {
      return "[" + k + "," + v + "]";
    }
  }

  public static void main(String[] args) {
    Dict<String, Integer> st = new LinearSearchDict<>();
    st.put("A", 1);
    st.put("B", 2);
    st.put("A", 2);
    st.put("C", 5);
    st.put("D", 7);
    LogUtil.log(st);
    LogUtil.log(st.get("B"));
    LogUtil.log(st.get("D"));

    for (String k : st.keys())
      LogUtil.log(k);
  }
}

