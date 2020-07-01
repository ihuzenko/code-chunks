package chunks.book.ch1.uf;

import static java.util.stream.IntStream.range;

/**
 * This is union find impl based on tree. Root node determined
 * when site points to itself in sites array. Also it contains
 * tree sizes array to make solution which trees are better to
 * connect.
 */
public class WeightedQuickUnionImpl extends AbstractUnionFind {

  private final int[] sites;
  private final int[] sitesTreeSizes;

  public WeightedQuickUnionImpl(int n) {
    super(n);
    sites = new int[connectedRegionsCount];
    sitesTreeSizes = new int[connectedRegionsCount];
    range(0, n).forEach(i -> {
      sites[i] = i;
      sitesTreeSizes[i] = 1;
    });
  }

  /**
   * Goes up in tree to find components root.
   *
   * @param p component
   * @return root of component's tree
   */
  @Override
  public int find(int p) {
    while (p != sites[p]) {
      p = sites[p];
    }
    return p;
  }

  @Override
  public void connect(int p, int q) {
    int pr = find(p); // get p root
    int qr = find(q); // get q root
    if (pr == qr) {
      return; // already connected
    }
    // determine which tree has smaller size
    if (sitesTreeSizes[pr] < sitesTreeSizes[qr]) {
      // connect p tree to q tree
      sites[pr] = qr;
      sitesTreeSizes[qr] += sitesTreeSizes[pr];
    } else {
      // connect q tree to p tree
      sites[qr] = pr;
      sitesTreeSizes[pr] += sitesTreeSizes[qr];
    }
    // two regions merged into one, decrease connected count
    connectedRegionsCount--;
  }
}
