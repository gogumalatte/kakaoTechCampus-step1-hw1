package Level3;

import Level2.MyCalculator_lv2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App_lv3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArithmeticCalculator_lv3<Double> calculator = new ArithmeticCalculator_lv3<>();
    double num1, num2;
    String operator, is_exit;

    while (true) {
      // 첫번쨰 정수 입력받기
      while (true) {
        try {
          System.out.print("계산기에 넣을 첫번째 수를 입력해주세요: ");
          num1 = scanner.nextDouble();
          scanner.nextLine();
          break;
        } catch (InputMismatchException e) {
          System.out.println("❗️잘못된 입력입니다. 숫자를 다시 입력해주세요❗");
          scanner.nextLine();
        }
      }

      // 두번째 정수 입력받기
      while (true) {
        try {
          System.out.print("계산기에 넣을 두번째 수를 입력해주세요: ");
          num2 = scanner.nextDouble();
          scanner.nextLine();
          break;
        } catch (InputMismatchException e) {
          System.out.println("❗️잘못된 입력입니다. 숫자를 다시 입력해주세요❗");
          scanner.nextLine();
        }
      }

      // 사칙연산 기호 입력받기
      while (true) {
        System.out.print("어떤 연산을 원하시나요(+, -, *, /): ");
        operator = scanner.nextLine();
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals(
            "/")) {
          break;
        } else {
          System.out.println("❗️잘못된 연산자를 입력하였습니다. 다시 입력해주세요❗️");
        }
      }

      // 연산
      try{
        OperatorType_lv3 operatorType = OperatorType_lv3.fromString(operator);
        double result = calculator.calculate(num1, num2, operatorType);
        System.out.println("결과: " + num1 + " " + operator + " " + num2 + " = " + result);
      } catch (ArithmeticException e) {
        System.out.println(e.getMessage());
      }

      // 저장된 결과 확인
      System.out.println("저장된 결과 리스트: " + calculator.getResults());

      // 결과 리스트에 접근하여 수정
      //calculator.setResults(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
      //System.out.println("수정된 결과: " + calculator.getResults());

      // 가장 먼저 저장된 데이터를 삭제
      System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (y/n): ");
      String input = scanner.nextLine();
      if (input.trim().equalsIgnoreCase("y")) {
        calculator.removeResult();
        System.out.println("삭제 후 저장된 결과 리스트: " + calculator.getResults());
      }

      // 특정 값보다 큰 결과 조회
      System.out.print("특정 값보다 큰 결과 조회하시겠습니까? (y/n): ");
      input = scanner.nextLine();
      if(input.trim().equalsIgnoreCase("y"))
      {
        double num;
        while(true)
        {
          try{
            System.out.print("숫자를 입력하세요: ");
            num = scanner.nextDouble();
            scanner.nextLine();
            break;
          }catch(InputMismatchException e)
          {
            System.out.println("❗️잘못된 입력입니다. 숫자를 다시 입력해주세요❗️");
            scanner.nextLine();
          }
        }
        System.out.println(num + "보다 큰 결과 리스트: " + calculator.getAtLeastResult(num));
      }

      // 연산을 계속 수행할지 확인
      System.out.print("더 계산하시겠습니까? 아무 문자나 입력하세요 (exit 입력 시 종료): ");
      is_exit = scanner.nextLine();
      if (is_exit.trim().equalsIgnoreCase("exit")) {
        System.out.println("=========계산기를 종료합니다.=========");
        break;
      } else {
        System.out.println("=========다음 연산을 시작합니다.=========");
      }
    }
  }
}
