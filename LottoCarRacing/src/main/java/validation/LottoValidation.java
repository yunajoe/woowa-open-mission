package validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidation extends BaseValidation {

  protected void checkValidNumberRange(int num) {
    boolean isValid = num >= 1 && num <= 45;
    if (!isValid) {
      throw new IllegalArgumentException("로또 번호는 1이상 45이하 여야 합니다.");
    }
  }


  // 로또 넘버 validation
  protected void lottoNumberValidate(List<Integer> lottoNumbers) {
    for (int lottoNum : lottoNumbers) {
      System.out.println("lottoNum =>" + lottoNum);
      checkValidNumberRange(lottoNum);
    }
  }



  // 보너스 넘버 validation
  protected void bonusNumberValidate(int bonusNumber) {

  }



  public void lottoValidate(String[] numbers, String bonusNum) {
    for (String num : numbers) {
      super.validate(num);
      super.checkValidConvertedNumber(num);
    }
    List<Integer> lottoNumbers =
        Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

    lottoNumberValidate(lottoNumbers);
//    
//    int bonusNumber = Integer.parseInt(bonusNum);
//    bonusNumberValidate(bonusNumber);



  }



}
