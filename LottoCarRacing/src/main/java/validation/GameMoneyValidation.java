package validation;

import config.GameMoneyEnum;

public class GameMoneyValidation extends BaseValidation {

  int UNIT = GameMoneyEnum.UNIT.getValue();
  int MAX_VALUE = GameMoneyEnum.MAX_VALUE.getValue();
  int MIN_VALUE = GameMoneyEnum.MIN_VALUE.getValue();
  

  protected void checkNonDivisibleThousand(int amount) {

    int remainder = amount % UNIT;
    if (remainder != 0) {
      throw new IllegalArgumentException("1000으로 나누었을 때 0으로 떨어져야 합니다.");
    }


  }

  protected void checkGameMoneyAmount(int amount) {
    boolean isValid = amount >= MIN_VALUE && amount <= MAX_VALUE;
    if (!isValid) {
      throw new IllegalArgumentException("최소 3000 최대 10000 입력해야 합니다.");
    }
  }

  protected int checkValidConvertedNumber(String str) {
    try {
      int amount = Integer.parseInt(str);
      return amount;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }

  }

  public void gameMoneyValidate(String str) {
    super.validate(str);
    int amount = checkValidConvertedNumber(str);
    checkGameMoneyAmount(amount);
    checkNonDivisibleThousand(amount);

  }

}
