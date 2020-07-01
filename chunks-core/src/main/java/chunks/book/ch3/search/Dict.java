package chunks.book.ch3.search;

/**
 * Associative map, containing unique keys and assigned values.
 * @param <K> key type
 * @param <V> value type
 */
public interface Dict<K, V> {

  V put(K key, V val);

  V get(K key);

  int size();

  Iterable<K> keys();

  V del(K key);

  default boolean has(K key) {
    return get(key) != null;
  }

  default boolean isEmpty() {
    return size() == 0;
  }
}