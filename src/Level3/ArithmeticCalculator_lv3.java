package Level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator_lv3<T extends Number> {
  private List<Double> results = new ArrayList<>();

  public double calculate(T num1, T num2, OperatorType_lv3 operator) throws ArithmeticException
  {
    double a = num1.doubleValue();
    double b = num2.doubleValue();
    double ret = 0;

    switch (operator) {
      case PLUS:
        ret = a + b;
        break;
      case MINUS:
        ret = a - b;
        break;
      case MULTIPLY:
        ret = a * b;
        break;
      case DIVIDE:
        if (b == 0) {
          throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        ret = a / b;
        break;
    }
    results.add(ret);
    return ret;
  }

  public List<Double> getResults() {
    return results;
  }

  public void setResults(List<Double> results) {
    this.results = results;
  }

  public void removeResult()
  {
    if (!results.isEmpty())
      results.remove(0);
    else
      System.out.println("삭제할 데이터가 없습니다.");
  }

  public List<Double> getAtLeastResult(double num)
  {
    return results.stream().filter(n->n>num).collect(Collectors.toList());
  }

}
