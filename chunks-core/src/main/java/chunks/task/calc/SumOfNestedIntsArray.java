package chunks.task.calc;

import java.util.LinkedList;

/**
 * Two methods accepting arrays of ints or nested arrays and
 * calculates sum of all int elements for all levels of nesting.
 * Example array is:
 * <p>
 * [ 1 , [1,2,3], [ [1,1],[0,-1] ] ]
 */
public class SumOfNestedIntsArray {

  public static int sumUsingRecursion(Object[] array) {
    int count = 0;
    for (Object arrOrInt : array) {
      if (arrOrInt instanceof Integer) {
        count += (Integer) arrOrInt;
      } else {
        count += sumUsingRecursion((Object[]) arrOrInt);
      }
    }
    return count;
  }

  public static int sumUsingCycles(Object[] arr) {
    int count = 0;
    LinkedList<Object[]> stack = new LinkedList<>();
    LinkedList<Integer> idxStack = new LinkedList<>();
    stack.addLast(arr);
    idxStack.addLast(0);
    outer:
    while (!stack.isEmpty()) {
      Object[] curr = stack.pollLast();
      for (int i = idxStack.pollLast(); i < curr.length; i++) {
        Object obj = curr[i];
        if (obj instanceof Integer) {
          count += (Integer) obj;
        } else {
          stack.addLast(curr);
          idxStack.addLast(++i);
          stack.addLast((Object[]) obj);
          idxStack.addLast(0);
          continue outer;
        }
      }
    }
    return count;
  }
}
