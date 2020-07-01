package chunks.task.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfNestedIntsArrayTest {

  private Object[] arr;

  @Before
  public void setUp() {
    arr = new Object[]{
        new Integer[]{1, 1, 0, 0},
        new Integer[][]{
            {1, 1, 1},
            {1, 0},
            {1}
        },
        1,
        new Object[][]{
            new Object[][]{
                new Integer[]{1, 1}
            }
        }
    };
  }

  @Test
  public void checkRecursive() {
    int sum = SumOfNestedIntsArray.sumUsingRecursion(arr);
    assertEquals(10, sum);
  }

  @Test
  public void checkCycles() {
    int sum = SumOfNestedIntsArray.sumUsingCycles(arr);
    assertEquals(10, sum);
  }
}