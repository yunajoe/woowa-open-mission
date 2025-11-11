package validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarValidation extends BaseValidation {


  protected void checkMatchWithGameMoney(List<String> carNames, int gameMoney) {
    int carCount = gameMoney / 1000;
    boolean isValid = carNames.size() == carCount;
    if (!isValid) {
      throw new IllegalArgumentException("입력한 금액에 맞는 자동차 갯수를 입력해야 합니다.");
    }
  }

  protected void checkDuplicatedName(List<String> carNames) {
    List<String> distinctCarNames = carNames.stream().distinct().collect(Collectors.toList());
    if (carNames.size() != distinctCarNames.size()) {
      throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
    }
  }
  
  
  protected void checkRankedCarNames(List<String> carNames, List<String> topRanksCarNames){
     Boolean isValid = carNames.containsAll(topRanksCarNames);
     if(!isValid) {
       throw new IllegalArgumentException("1 ~ 3등 차 이름은 경주할 자동차 이름에 포함되어야 합니다.");
     }
  }
  
  
  


  protected void checkValidCarNameLength(String str) {
    boolean isValid = str.length() >= 1 && str.length() <= 5;
    if (!isValid) {
      throw new IllegalArgumentException("자동차 이름 길이는 최소 한글자 최대 다섯글자입니다.");
    }
  }




  public List<String> carValidate(String carNames, String topRanksCarNames, int amount) {
    List<String> carList = Arrays.asList(carNames.split(","));
    List<String> topRanksCarList = Arrays.asList(topRanksCarNames.split(","));
    
    
    checkMatchWithGameMoney(carList, amount);
    checkDuplicatedName(carList);
    

    for (String rawCar : carList) {
      String car = rawCar.trim();

      super.checkNull(car);
      super.checkBlank(car);
      super.checkContainBlank(car);
      checkValidCarNameLength(car);
    }
    
    
    checkDuplicatedName(topRanksCarList);
    checkRankedCarNames(carList, topRanksCarList);

    return carList;


  }

}
