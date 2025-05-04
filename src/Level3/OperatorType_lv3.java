package Level3;

public enum OperatorType_lv3 {
  PLUS("+"),
  MINUS("-"),
  MULTIPLY("*"),
  DIVIDE("/");

  private final String symbol;

  OperatorType_lv3(String symbol) {
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public static OperatorType_lv3 fromString(String input) {
    for (OperatorType_lv3 op : OperatorType_lv3.values()) {
      if (op.getSymbol().equals(input)) {
        return op;
      }
    }
    throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + input);
  }
}
