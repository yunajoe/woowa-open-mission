package model;

import java.util.List;

public class LottoNumber {

  private List<Integer> numbers;
  private int bonusNumber;

  public LottoNumber(List<Integer> numbers, int bonusNumber) {
    this.numbers = numbers;
    this.bonusNumber = bonusNumber;
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }


}
