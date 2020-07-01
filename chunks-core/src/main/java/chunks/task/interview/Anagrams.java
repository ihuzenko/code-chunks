package chunks.task.interview;

/**
 * Write an application that reverses all the words of input text:
 *
 *   E.g. "abcd efgh" => "dcba hgfe"
 *
 * All non-letter symbols should stay on the same places:
 *
 *   E.g. "a1bcd efg!h" => "d1cba hgf!e"
 *
 * Use Latin alphabet for test only.
 */
public class Anagrams {

  private static String getAnagram(String source) {
    char[] chars = source.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (!Character.isSpaceChar(chars[i])) {
        int s = i;
        do {
          i++;
        } while (i < chars.length && !Character.isSpaceChar(chars[i]));
        reverseWord(chars, s, i - 1);
      }
    }
    return new String(chars);
  }

  private static void reverseWord(char[] chars, int s, int e) {
    for (int i = s, j = e; i < j; i++) {
      if (Character.isAlphabetic(chars[i])) {
        while (!Character.isAlphabetic(chars[j]) && i < j) {
          j--;
        }
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j--] = tmp;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(getAnagram("?2s -a+?def--- ----o---s---  sor1?ab      ab d!ab      k"));
                                 //?2s -f+?eda--- ----s---o---  bar1?os      ba b!ad      k
  }
}
