package samples;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Warmup(iterations = 1)
@Fork(1)
public class Sample2 {

  @Benchmark
  @BenchmarkMode(Mode.Throughput)
  @OutputTimeUnit(TimeUnit.SECONDS)
  public void measureThroughput() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void measureAvgTime() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
  }

  @Benchmark
  @BenchmarkMode(Mode.SampleTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void measureSamples() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
  }

  @Benchmark
  @BenchmarkMode(Mode.SingleShotTime)
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public void measureSingleShot() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(100);
  }

  /* RUN COMMAND:
   * mvn clean package && java -jar target/benchmarks.jar samples.Sample2
   *
   */
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Sample2.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
