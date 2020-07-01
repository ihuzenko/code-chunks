package chunks.book.ch1.uf;

import static java.util.stream.IntStream.range;

/**
 * Improvement of QuickFindImpl by decrementing connect time.
 * <p>
 * O(n) table:
 * construct = N
 * connect = tree depth
 * find = tree depth
 */
public class QuickUnionImpl extends AbstractUnionFind {

  private final int[] sites;

  public QuickUnionImpl(int n) {
    super(n);
    sites = new int[n];
    range(0, n).forEach(i -> sites[i] = i);
  }

  @Override
  public int find(int p) {
    while (p != sites[p])
      p = sites[p];
    return p;
  }

  @Override
  public void connect(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ)
      return;
    sites[rootP] = rootQ;
    connectedRegionsCount--;
  }
}