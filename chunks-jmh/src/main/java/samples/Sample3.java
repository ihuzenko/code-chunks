package samples;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Warmup(iterations = 1)
@Fork(3)
public class Sample3 {

  @State(Scope.Benchmark)
  public static class BenchmarkState {

    volatile double x = Math.PI;
  }

  @State(Scope.Thread)
  public static class ThreadState {

    volatile double x = Math.PI;
  }

  @Benchmark
  public void unshared(ThreadState ts, Blackhole bh) {
    ts.x++;
    bh.consume(ts.x);
  }

  @Benchmark
  public void shared(BenchmarkState bs, Blackhole bh) {
    bs.x++;
    bh.consume(bs.x);
  }

  /* RUN COMMAND:
   * mvn clean package && java -jar target/benchmarks.jar samples.Sample3
   *
   */
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Sample3.class.getSimpleName())
        .threads(4)
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}