package samples;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Origin:
 * https://hg.openjdk.java.net/code-tools/jmh/file/c8f9f5b85cd9/jmh-samples/src/main/java/org/openjdk/jmh/samples/JMHSample_01_HelloWorld.java
 */
public class Sample1 {

  @Benchmark
  public void helloWorld() {
    // empty
  }

  /* RUN COMMAND:
   * mvn clean package && java -jar target/benchmarks.jar samples.Sample1
   * LIST AVAILABLE EXEC OPTIONS:
   * java -jar target/benchmarks.jar -h
   */
  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Sample1.class.getSimpleName())
        .forks(1)
        .build();
    new Runner(opt).run();
  }

  /*
# JMH version: 1.22
# VM version: JDK 1.8.0_222, OpenJDK 64-Bit Server VM, 25.222-b10
# VM invoker: /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
# VM options: <none>
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: samples.Sample1.helloWorld

# Run progress: 0.00% complete, ETA 00:08:20
# Fork: 1 of 5
# Warmup Iteration   1: 3316757942.764 ops/s
# Warmup Iteration   2: 3319686913.112 ops/s
# Warmup Iteration   3: 3324101366.743 ops/s
# Warmup Iteration   4: 3313545821.743 ops/s
# Warmup Iteration   5: 3324498208.470 ops/s
Iteration   1: 3328568033.429 ops/s
Iteration   2: 3328418504.781 ops/s
Iteration   3: 3327227119.191 ops/s
Iteration   4: 3327202347.380 ops/s
Iteration   5: 3325433663.987 ops/s

# Run progress: 20.00% complete, ETA 00:06:41
# Fork: 2 of 5
# Warmup Iteration   1: 3323207682.614 ops/s
# Warmup Iteration   2: 3323940746.455 ops/s
# Warmup Iteration   3: 3305157213.493 ops/s
# Warmup Iteration   4: 3215304366.737 ops/s
# Warmup Iteration   5: 3317113555.139 ops/s
Iteration   1: 3325423561.803 ops/s
Iteration   2: 3312727376.837 ops/s
Iteration   3: 3318471868.491 ops/s
Iteration   4: 3319251266.468 ops/s
Iteration   5: 3328027368.414 ops/s

# Run progress: 40.00% complete, ETA 00:05:00
# Fork: 3 of 5
# Warmup Iteration   1: 3299329902.724 ops/s
# Warmup Iteration   2: 3303734578.383 ops/s
# Warmup Iteration   3: 3266751820.086 ops/s
# Warmup Iteration   4: 3212333047.322 ops/s
# Warmup Iteration   5: 3258732800.573 ops/s
Iteration   1: 3272145444.963 ops/s
Iteration   2: 3296910762.066 ops/s
Iteration   3: 3268438536.634 ops/s
Iteration   4: 3308495237.404 ops/s
Iteration   5: 3317663330.024 ops/s

# Run progress: 60.00% complete, ETA 00:03:20
# Fork: 4 of 5
# Warmup Iteration   1: 3313118248.673 ops/s
# Warmup Iteration   2: 3326408373.337 ops/s
# Warmup Iteration   3: 3274805972.168 ops/s
# Warmup Iteration   4: 3304169567.075 ops/s
# Warmup Iteration   5: 3314280016.490 ops/s
Iteration   1: 3328073212.780 ops/s
Iteration   2: 3321002802.772 ops/s
Iteration   3: 3316506252.398 ops/s
Iteration   4: 3314686325.195 ops/s
Iteration   5: 3325588057.259 ops/s

# Run progress: 80.00% complete, ETA 00:01:40
# Fork: 5 of 5
# Warmup Iteration   1: 3311099241.191 ops/s
# Warmup Iteration   2: 3325756056.975 ops/s
# Warmup Iteration   3: 3330647500.781 ops/s
# Warmup Iteration   4: 3324837592.530 ops/s
# Warmup Iteration   5: 3322318686.837 ops/s
Iteration   1: 3323701542.596 ops/s
Iteration   2: 3325986287.171 ops/s
Iteration   3: 3318420039.298 ops/s
Iteration   4: 3312915572.107 ops/s
Iteration   5: 3316480577.643 ops/s


Result "samples.Sample1.helloWorld":
  3316310603.644 ±(99.9%) 11803747.141 ops/s [Average]
  (min, avg, max) = (3268438536.634, 3316310603.644, 3328568033.429), stdev = 15757664.725
  CI (99.9%): [3304506856.503, 3328114350.784] (assumes normal distribution)


# Run complete. Total time: 00:08:21

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark            Mode  Cnt           Score          Error  Units
Sample1.helloWorld  thrpt   25  3316310603.644 ± 11803747.141  ops/s
*/
}
