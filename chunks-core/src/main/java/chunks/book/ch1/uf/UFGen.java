package chunks.book.ch1.uf;

import chunks.util.LogUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static chunks.util.LogUtil.log;

public class UFGen {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("./src/main/resources/tinyUF.txt");
    LogUtil.log(path);
    List<String> list = new ArrayList<>();
    List<Integer> integerList = IntStream.range(0, 10).boxed()
        .collect(Collectors.toList());
    shuffleAdd(list, integerList);
    shuffleAdd(list, integerList);
    shuffleAdd(list, integerList);
//    if (Files.exists(path))
//      Files.delete(path);
//    Files.write(path, list);
  }

  private static void shuffleAdd(List<String> list, List<Integer> integerList) {
    Collections.shuffle(integerList);
    for (int i = 0; i < 9; i += 2) {
      list.add(String.format("%s %s", integerList.get(i), integerList.get(i + 1)));
    }
  }
}
