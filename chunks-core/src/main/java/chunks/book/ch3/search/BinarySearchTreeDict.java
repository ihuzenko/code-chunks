package chunks.book.ch3.search;

public class BinarySearchTreeDict<K extends Comparable<K>, V> implements ComparableKeysDict<K, V> {

  private Node root;

  @Override
  public K min() {
    return root == null ? null : min(root);
  }

  private K min(Node node) {
    return (node.left == null)
        ? node.key
        : min(node.left);
  }

  @Override
  public K max() {
    return root == null ? null : max(root);
  }

  private K max(Node node) {
    return (node.right == null)
        ? node.key
        : max(node.right);
  }

  @Override
  public K floor(K key) {
    final Node f;
    return (f = floor(root, key)) == null ? null : f.key;
  }

  private Node floor(Node node, K key) {
    if (node == null) {
      return null;
    }
    Node rf;
    int comparison = key.compareTo(node.key);
    if (comparison < 0) {
      return floor(node.left, key);
    } else if (comparison > 0 && (rf = floor(node.right, key)) != null) {
      return rf;
    }
    return node; // less or equal
  }

  @Override
  public K ceil(K key) {
    final Node c;
    return (c = ceil(root, key)) == null ? null : c.key;
  }

  private Node ceil(Node node, K key) {
    if (node == null) {
      return null;
    }
    Node lc;
    int comparison = key.compareTo(node.key);
    if (comparison > 0) {
      return ceil(node.right, key);
    } else if (comparison < 0 && (lc = ceil(node.left, key)) != null) {
      return lc;
    }
    return node; // greater or equal
  }

  @Override
  public int rank(K key) {
    return 0;
  }

  @Override
  public K select(int rank) {
    return null;
  }

  @Override
  public Iterable<K> keys(K low, K high) {
    return null;
  }

  @Override
  public V put(K key, V val) {
    @SuppressWarnings("unchecked") final V[] oldVal = (V[]) new Object[1];
    root = put(root, key, val, oldVal);
    return oldVal[0];
  }

  private Node put(Node node, K key, V val, V[] oldVal) {
    if (node == null) {
      return new Node(key, val, 1);
    }
    final int comparison = key.compareTo(node.key);
    if (comparison < 0) {
      node.left = put(node.left, key, val, oldVal);
    } else if (comparison > 0) {
      node.right = put(node.right, key, val, oldVal);
    } else {
      oldVal[0] = node.val;
      node.val = val;
    }
    node.count = 1 + size(node.left) + size(node.right);
    return node;
  }

  @Override
  public V get(K key) {
    return get(root, key);
  }

  private V get(final Node node, final K key) {
    if (node == null) {
      return null; // not found
    }
    final int comparison = key.compareTo(node.key);
    if (comparison < 0) {
      return get(node.left, key);
    } else if (comparison > 0) {
      return get(node.right, key);
    }
    return node.val; // found
  }

  @Override
  public int size() {
    return size(root);
  }

  private int size(Node node) {
    return node == null ? 0 : node.count;
  }

  @Override
  public V del(K key) {
    return null;
  }


  private class Node {

    final K key;
    V val;
    int count;
    Node left, right;

    public Node(K key, V val, int count) {
      this.key = key;
      this.val = val;
      this.count = count;
    }
  }
}
