package chunks.book.ch3.search;

import java.util.Arrays;

import chunks.util.ArrUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class BinarySearchTreeDictTest {

  private ComparableKeysDict<Integer, String> dict;

  @Before
  public void init() {
    dict = new BinarySearchTreeDict<>();
  }


  @Test
  public void min() throws Exception {
    int[] shuffled = ArrUtil.shuffled(ArrUtil.indexed(10));
    Arrays.stream(shuffled).boxed().forEach(v -> dict.put(v, ""));
    assertEquals((Integer) 0, dict.min());
  }

  @Test
  public void max() throws Exception {
  }

  @Test
  public void floor() throws Exception {
    int[] keys = {100, 200, 300, 400, 500, 600, 700, 800,
        900, 1000, 1100, 1200, 1300, 1400, 1500};
    ArrUtil.shuffled(keys);
    Arrays.stream(keys).boxed().forEach(k -> dict.put(k, ""));

    assertEquals((Integer) 500, dict.floor(500));
    assertEquals((Integer) 500, dict.floor(599));
    assertEquals((Integer) 500, dict.floor(501));

    assertEquals((Integer) 300, dict.floor(320));
    assertEquals((Integer) 300, dict.floor(300));
    assertEquals((Integer) 300, dict.floor(302));
  }

  @Test
  public void ceil() throws Exception {
    int[] keys = {100, 200, 300, 400, 500, 600, 700, 800,
        900, 1000, 1100, 1200, 1300, 1400, 1500};
    ArrUtil.shuffled(keys);
    Arrays.stream(keys).boxed().forEach(k -> dict.put(k, ""));

    assertEquals((Integer) 500, dict.ceil(500));
    assertEquals((Integer) 600, dict.ceil(599));
    assertEquals((Integer) 600, dict.ceil(501));

    assertEquals((Integer) 400, dict.ceil(320));
    assertEquals((Integer) 300, dict.ceil(300));
    assertEquals((Integer) 400, dict.ceil(302));
  }

  @Test
  public void rank() throws Exception {
  }

  @Test
  public void select() throws Exception {
  }

  @Test
  public void keys() throws Exception {
  }

  @Test
  public void put() throws Exception {
  }

  @Test
  public void get() throws Exception {
    dict.put(100, "AAA");
    dict.put(10, "AA");
    dict.put(50, "BB");
    dict.put(500, "BBB");
    dict.put(1000, "AAAA");
    dict.put(5, "B");
    dict.put(1, "A");
    dict.put(0, "O");

    assertEquals("BBB", dict.get(500));
    assertEquals("BB", dict.get(50));
    assertEquals("AA", dict.get(10));
    assertEquals("AAA", dict.get(100));
    assertEquals("AAAA", dict.get(1000));
    assertEquals("B", dict.get(5));
    assertEquals("A", dict.get(1));
    assertEquals("O", dict.get(0));
  }

  @Test
  public void size() throws Exception {
    assertEquals(dict.size(), 0);
    dict.put(10, "A");
    dict.put(9, "B");
    dict.put(12, "C");
    assertEquals(dict.size(), 3);
    dict.put(12, "C");
    assertEquals(dict.size(), 3);
  }

  @Test
  public void del() throws Exception {
  }
}
