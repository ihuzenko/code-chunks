package chunks.task.converter;

import java.util.stream.IntStream;

import org.junit.Test;

import static chunks.task.converter.NumberSystem.BINARY;
import static chunks.task.converter.NumberSystem.DECIMAL;
import static chunks.util.LogUtil.log;
import static org.junit.Assert.assertEquals;

public class NumberSystemTest {

  @Test
  public void binaryToOctal() {
    String octal = BINARY.toOctal("111111");
    log(octal);
    assertEquals("77", octal);
  }

  @Test
  public void binaryToDecimal() {
    String dec = BINARY.toDecimal("1010");
    assertEquals("10", dec);
    dec = BINARY.toDecimal("1110110101010101010");
    assertEquals("486058", dec);
    dec = BINARY.toDecimal("01110111101010111010010100010101110");
    assertEquals("16061900974", dec);
    dec = BINARY.toDecimal("111");
    assertEquals("7", dec);
  }

  @Test
  public void binaryToHexadecimal() {
    String hex = BINARY.toHexadecimal("11001111");
    assertEquals("CF", hex);
    hex = BINARY.toHexadecimal("10111101010");
    assertEquals("5EA", hex);
    hex = BINARY.toHexadecimal("00110011010101011011001011011100");
    assertEquals("3355B2DC", hex);
  }

  @Test
  public void decimalToOctal() {
    String oct = DECIMAL.toOctal("125");
    assertEquals("175", oct);
    IntStream.range(0, 8).mapToObj(String::valueOf)
        .forEach(i -> assertEquals(i, DECIMAL.toOctal(i)));
    oct = DECIMAL.toOctal("7558");
    assertEquals("16606", oct);
  }
}