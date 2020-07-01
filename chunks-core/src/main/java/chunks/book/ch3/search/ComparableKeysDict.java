package chunks.book.ch3.search;

/**
 * Map based on comparable keys, which allows to use ordering and provide
 * additional operations to parent interface.
 *
 * @param <K> type of key
 * @param <V> type of value
 */
public interface ComparableKeysDict<K extends Comparable<K>, V> extends Dict<K, V> {

  /**
   * Search smallest key in table
   *
   * @return min key
   */
  K min();

  /**
   * Search biggest key in table
   *
   * @return max key
   */
  K max();

  /**
   * Search first less or equal key.
   * @param key to check
   * @return less or equal key
   */
  K floor(K key);

  /**
   * Search first greater or equal key.
   * @param key to check
   * @return less or equal key
   */
  K ceil(K key);

  /**
   * Returns how much elements in the given table are less than key.
   *
   * @param key to check
   * @return number of keys less than given key
   */
  int rank(K key);

  /**
   * Find key by its rank.
   *
   * @param rank rank of key
   * @return key
   */
  K select(int rank);

  Iterable<K> keys(K low, K high);

  default int size(K low, K high) {
    return high.compareTo(low) < 0 ? 0 : rank(high) - rank(low) + (has(high) ? 1 : 0);
  }

  @Override
  default Iterable<K> keys() {
    return keys(min(), max());
  }
}