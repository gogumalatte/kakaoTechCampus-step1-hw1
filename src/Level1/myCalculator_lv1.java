package Level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class myCalculator_lv1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num1, num2;
    String operator, is_exit;

    while (true) {
      // 첫번쨰 정수 입력받기
      while (true) {
        try {
          System.out.print("계산기에 넣을 첫번째 정수를 입력해주세요(0이상): ");
          num1 = scanner.nextInt();
          if (num1 >= 0) {
            break;
          } else {
            System.out.println("❗️0이상의 정수를 다시 입력해주세요❗️");
          }
        } catch (InputMismatchException e) {
          System.out.println("❗️잘못된 입력입니다. 0 이상의 정수를 다시 입력해주세요❗");
          scanner.nextLine();
        }
      }

      // 두번째 정수 입력받기
      while (true) {
        try {
          System.out.print("계산기에 넣을 두번째 정수를 입력해주세요(0이상): ");
          num2 = scanner.nextInt();
          if (num2 >= 0) {
            break;
          } else {
            System.out.println("❗️0이상의 정수를 다시 입력해주세요❗️");
          }
        } catch (InputMismatchException e) {
          System.out.println("❗️잘못된 입력입니다. 0 이상의 정수를 다시 입력해주세요❗");
          scanner.nextLine();
        }
      }

      // 사칙연산 기호 입력받기
      while (true) {
        System.out.print("어떤 연산을 원하시나요(+, -, *, /): ");
        operator = scanner.next();
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals(
            "/")) {
          break;
        } else {
          System.out.println("❗️잘못된 연산자를 입력하였습니다. 다시 입력해주세요❗️");
        }
      }

      // 연산
      System.out.print("결과: ");
      switch (operator) {
        case "+":
          System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
          break;
        case "-":
          System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
          break;
        case "*":
          System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
          break;
        case "/":
          try {
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
          } catch (ArithmeticException e) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
          }
          break;
      }

      // 연산을 계속 수행할지 확인
      System.out.print("더 계산하시겠습니까? 아무 문자나 입력하세요 (exit 입력 시 종료): ");
      scanner.nextLine();
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
