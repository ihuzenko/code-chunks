package chunks.task.interview;

import chunks.util.LogUtil;

public class RotateArray {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4};
    rotateBrutForce(a, 2);
    LogUtil.log(a);
  }

  private static void rotateBrutForce(int[] nums, int k) {
    int lastIdx = nums.length - 1;
    for (int i = k - 1; i >= 0; i--) {
      for (int j = i; j < lastIdx; j++) {
        int tmp = nums[j];
        nums[j] = nums[j + 1];
        nums[j + 1] = tmp;
      }
      lastIdx--;
    }
  }
}
