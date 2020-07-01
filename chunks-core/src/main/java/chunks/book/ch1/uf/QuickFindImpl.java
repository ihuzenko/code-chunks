package chunks.book.ch1.uf;

import java.util.Arrays;

import static java.util.stream.IntStream.range;

/**
 * Naive implementation of union find.
 *
 * O(n) table:
 * constructor = N
 * connect = N
 * find = 1
 */
public class QuickFindImpl extends AbstractUnionFind {

  private final int[] sites;

  public QuickFindImpl(int n) {
    super(n);
    sites = new int[n];
    range(0, n).forEach(i -> sites[i] = i);
  }

  @Override
  public int find(int p) {
    return sites[p];
  }

  @Override
  public void connect(int p, int q) {
    if (isConnected(p, q)) {
      return;
    }
    int oldP = sites[p];
    for (int i = 0; i < sites.length; i++) {
      if (oldP == sites[i]) {
        sites[i] = q;
      }
    }
    connectedRegionsCount--;
  }

  @Override
  public String toString() {
    return count() + ":" + Arrays.toString(sites);
  }
}
