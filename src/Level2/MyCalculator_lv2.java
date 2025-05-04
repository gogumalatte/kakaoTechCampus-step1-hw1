package Level2;

import java.util.ArrayList;
import java.util.List;

public class MyCalculator_lv2 {
  private List<Integer> results = new ArrayList<>();

  public int calculate(int num1, int num2, String operator) throws ArithmeticException
  {
    int ret = 0;
    switch (operator) {
      case "+":
        ret = num1 + num2;
        break;
      case "-":
        ret = num1 - num2;
        break;
      case "*":
        ret = num1 * num2;
        break;
      case "/":
        if (num2 == 0) {
          throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
        ret = num1 / num2;
        break;
    }
    results.add(ret);
    return ret;
  }

  public List<Integer> getResults() {
    return results;
  }

  public void setResults(List<Integer> results) {
    this.results = results;
  }

  public void removeResult()
  {
    results.remove(0);
  }
}
