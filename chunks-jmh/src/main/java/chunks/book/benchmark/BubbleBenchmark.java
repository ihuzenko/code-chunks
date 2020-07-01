package chunks.book.benchmark;

import java.util.concurrent.TimeUnit;

import chunks.book.ch2.sorting.Bubble;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
@Fork(1)
public class BubbleBenchmark {

  @Benchmark
  public void bubbleWorstCase100_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getWorst_100_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  @Benchmark
  public void bubbleWorstCase1_000_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getWorst_1_000_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  @Benchmark
  public void bubbleBestCase100_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getBest_100_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  @Benchmark
  public void bubbleBestCase1_000_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getBest_1_000_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  @Benchmark
  public void bubbleRandomCase100_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getRandom_100_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  @Benchmark
  public void bubbleRandomCase1_000_000(SortState sortState, Blackhole bh) {
    int[] arr = sortState.getRandom_1_000_000();
    Bubble.sort(arr);
    bh.consume(arr);
  }

  // mvn clean package && java -jar target/benchmarks.jar chunks.book.benchmark.BubbleBenchmark
  public static void main(String[] args) throws RunnerException {
    Options opts = new OptionsBuilder()
        .include(BubbleBenchmark.class.getSimpleName())
        .build();
    new Runner(opts).run();
  }
}
