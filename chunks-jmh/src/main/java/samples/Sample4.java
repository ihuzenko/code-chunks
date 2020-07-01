package samples;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Thread)
public class Sample4 {

  private double x = 0;

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @Warmup(iterations = 1)
  @Fork(2)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void measure(Blackhole bh) {
    x++;
    bh.consume(x);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Sample4.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(opt).run();
  }
}
