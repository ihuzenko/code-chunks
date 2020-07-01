package chunks.task.converter;

import java.util.LinkedList;
import java.util.function.LongFunction;
import java.util.stream.IntStream;

public enum NumberSystem {
  BINARY(2) {
    /**
     * Alghorithm simply splits binary into group of three, then calculates every digit
     * for the group.
     *
     * Example: 101001111 (binary)-> 101 001 111 (binary)-> 5 1 7 (octal)
     *
     * @param num binary number
     * @return octal number
     */
    @Override
    public String toOctal(String num) {
      StringBuilder nb = new StringBuilder();
      int octNum = 0;
      for (int bitIdx = num.length() - 1, octCount = 3; bitIdx > -1; bitIdx--) {
        final boolean isBitSet = '1' == num.charAt(bitIdx);
        if (--octCount == 0) {
          if (isBitSet) {
            octNum += 4;
          }
          nb.append(octNum);
          // reset group of three and value
          octNum = 0;
          octCount = 3;
        } else if (isBitSet) {
          octNum += (octCount == 2) ? 1 : 2;
        }
      }
      if (octNum != 0) {
        nb.append(octNum);
      }
      // get rid of reverse
      return nb.reverse().toString();
    }

    @Override
    public String toDecimal(String num) {
      long decimal = 0;
      for (int i = 0, degree = num.length() - 1; i < num.length(); i++, degree--) {
        if (num.charAt(i) == '0') {
          continue;
        }
        long v = 1;
        if (degree > 0) {
          v = 2;
          // may be improved using cache
          for (int d = 1; d < degree; d++) {
            v *= 2;
          }
        }
        decimal += v;
      }
      return String.valueOf(decimal);
    }

    @Override
    public String toHexadecimal(String number) {
      int[] qvals = {8, 4, 2, 1};
      LinkedList<String> num = new LinkedList<>();
      int quarter = 4, hex = 0;
      for (int idx = number.length() - 1; idx > -1; idx--) {
        quarter--;
        boolean isSet = number.charAt(idx) == '1';
        if (isSet) {
          hex += qvals[quarter];
        }
        if (quarter == 0) {
          quarter = 4;
          num.addFirst(HEXADECIMAL.digits[hex]);
          hex = 0;
        }
      }
      if (hex != 0) {
        num.addFirst(HEXADECIMAL.digits[hex]);
      }
      return String.join("", num);
    }
  },
  DECIMAL(10) {
    @Override
    public String toOctal(String num) {
      return convert(num, 8, String::valueOf);
    }

    @Override
    public String toBinary(String num) {
      return convert(num, 2, String::valueOf);
    }

    @Override
    public String toHexadecimal(String num) {
      return convert(num, 16, digit -> HEXADECIMAL.digits[(int) digit]);
    }

    private String convert(String num, int base, LongFunction<String> digitFunc) {
      long dec = Long.parseLong(num);
      LinkedList<String> bin = new LinkedList<>();
      if (dec == 0) {
        bin.addFirst("0");
      } else {
        while (dec != 0) {
          bin.addFirst(digitFunc.apply(dec % base));
          dec /= base;
        }
      }
      return String.join("", bin);
    }
  },
  OCTAL(8) {
    @Override
    public String toDecimal(String num) {
      long dec = 0;
      int limit = num.length() - 1;
      for (int idx = 0; idx < limit; idx++) {
        dec = (dec + Character.getNumericValue(num.charAt(idx))) * 8;
      }
      dec += Character.getNumericValue(num.charAt(limit));
      return String.valueOf(dec);
    }

    @Override
    public String toBinary(String num) {
      String[] triplets = {"000", "001", "010", "011", "100", "101", "110", "111"};
      LinkedList<String> bin = new LinkedList<>();
      for (int idx = 0; idx < num.length(); idx++) {
        int tripletIdx = Character.getNumericValue(num.charAt(idx));
        bin.add(triplets[tripletIdx]);
      }
      return String.join("", bin);
    }

    @Override
    public String toHexadecimal(String num) {
      return BINARY.toHexadecimal(toBinary(num));
    }
  },
  HEXADECIMAL(16) {
    @Override
    public String toOctal(String num) {
      return BINARY.toOctal(toBinary(num));
    }

    @Override
    public String toDecimal(String num) {
      long dec = 0;
      int limit = num.length() - 1;
      for (int i = 0; i < limit; i++) {
        dec = (dec + toInt(num.charAt(i))) * 16;
      }
      dec += toInt(num.charAt(limit));
      return String.valueOf(dec);
    }

    @Override
    public String toBinary(String num) {
      String[] vals = {
          "0000", // 0
          "0001", // 1
          "0010", // 2
          "0011", // 3
          "0100", // 4
          "0101", // 5
          "0110", // 6
          "0111", // 7
          "1000", // 8
          "1001", // 9
          "1010", // A
          "1011", // B
          "1100", // C
          "1101", // D
          "1110", // E
          "1111"  // F
      };
      StringBuilder sb = new StringBuilder(num.length() * 4);
      for (int i = 0; i < num.length(); i++)
        sb.append(vals[toInt(num.charAt(i))]);
      return sb.toString();
    }

    private int toInt(char hex) {
      switch (hex) {
        case 'A':
          return 10;
        case 'B':
          return 11;
        case 'C':
          return 12;
        case 'D':
          return 13;
        case 'E':
          return 14;
        case 'F':
          return 15;
        default:
          return Character.getNumericValue(hex);
      }
    }

  };

  private final String[] digits;

  NumberSystem(int base) {
    this.digits = IntStream.range(0, base)
        .mapToObj(this::toString)
        .toArray(String[]::new);
  }

  private String toString(int digit) {
    switch (digit) {
      case 10:
        return "A";
      case 11:
        return "B";
      case 12:
        return "C";
      case 13:
        return "D";
      case 14:
        return "E";
      case 15:
        return "F";
      default:
        return String.valueOf(digit);
    }
  }

  public String toOctal(String num) {
    return num;
  }

  public String toDecimal(String num) {
    return num;
  }

  public String toBinary(String num) {
    return num;
  }

  public String toHexadecimal(String num) {
    return num;
  }
}
