package validation;

import config.GameMoneyEnum;

public class GameMoneyValidation extends BaseValidation {

  int UNIT = GameMoneyEnum.UNIT.getValue();
  int MAX_VALUE = GameMoneyEnum.MAX_VALUE.getValue();
  int MIN_VALUE = GameMoneyEnum.MIN_VALUE.getValue();


  protected void checkNonDivisibleThousand(long amount) {

    long remainder = amount % UNIT;
    if (remainder != 0) {
      throw new IllegalArgumentException("1000으로 나누었을 때 0으로 떨어져야 합니다.");
    }


  }

  protected void checkGameMoneyAmount(long amount) {
    boolean isValid = amount >= MIN_VALUE && amount <= MAX_VALUE;
    if (!isValid) {
      throw new IllegalArgumentException("최소 5000 최대 100000 입력해야 합니다.");
    }
  }



  //세션에 저장되어 있는 게임머니가 0원일때

  // 세션에 저장되어 있는 게이머니가 값이 있을때 (로또 당첨금액)
  public void gameMoneyValidate( String str) {
    super.validate(str);
    long amount = super.checkValidConvertedNumber(str);
    checkGameMoneyAmount(amount);
    checkNonDivisibleThousand(amount);

  }

}
