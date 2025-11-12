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
  
  protected void checkBonusNumberInLottoNumber(List<Integer> lottoNumbers, int bonusNumber){
    boolean isNotValid = lottoNumbers.contains(bonusNumber);
    if(isNotValid) {
      throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복되면 안됩니다."); 
    }  
    
  }


  protected void lottoNumberValidate(List<Integer> lottoNumbers) {
    for (int lottoNum : lottoNumbers) {
      checkValidNumberRange(lottoNum);
    }
  }



  protected void bonusNumberValidate(List<Integer> lottoNumbers, int bonusNumber) {
    checkValidNumberRange(bonusNumber);
    checkBonusNumberInLottoNumber(lottoNumbers, bonusNumber);
  }



  public void lottoValidate(String[] numbers, String bonusNum) {
    // 로또 번호 validation
    for (String num : numbers) {
      super.validate(num);
      super.checkValidConvertedNumber(num);
    }

    List<Integer> lottoNumbers =
        Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

    lottoNumberValidate(lottoNumbers);


    // 보너스 번호 validaiton
    super.validate(bonusNum);
    super.checkValidConvertedNumber(bonusNum);
    int bonusNumber = Integer.parseInt(bonusNum);
    bonusNumberValidate(lottoNumbers, bonusNumber);



  }



}
