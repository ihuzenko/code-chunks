package chunks.book.ch1.uf;

public interface UnionFind {
  int find(int p);
  void connect(int p, int q);
  int count();
  default boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }
}
