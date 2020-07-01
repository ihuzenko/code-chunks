package chunks.book.ch1.uf;

public abstract class AbstractUnionFind implements UnionFind {

  /**
   * When all sites are connected - this should be 1.
   * At the start we assume that every site resides in it's
   * own region, so it equals to sites.length.
   */
  int connectedRegionsCount;

  public AbstractUnionFind(int connectedRegionsCount) {
    this.connectedRegionsCount = connectedRegionsCount;
  }

  @Override
  public final int count() {
    return connectedRegionsCount;
  }
}
