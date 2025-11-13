package validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.CarList;


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


  protected void checkTopRankCarsInRaceCars(List<String> carNames, List<String> topRanksCarNames) {
    Boolean isValid = carNames.containsAll(topRanksCarNames);
    if (!isValid) {
      throw new IllegalArgumentException("1 ~ 3등 차 이름은 경주할 자동차 이름에 포함되어야 합니다.");
    }
  }

  protected void checkRankedCarsLength(List<String> topRanksCarNames) {
    boolean isValid = topRanksCarNames.size() == 3;
    if (!isValid) {
      throw new IllegalArgumentException("3개의 자동차만 입력해야 합니다.");
    }

  }



  protected void checkValidCarNameLength(String str) {
    boolean isValid = str.length() >= 1 && str.length() <= 5;
    if (!isValid) {
      throw new IllegalArgumentException("자동차 이름 길이는 최소 한글자 최대 다섯글자입니다.");
    }
  }



  public CarList carValidate(String carNames, String topRanksCarNames, int amount) {
    List<String> carList = Arrays.stream(carNames.split(",")).map(String::trim).toList();
    List<String> topRanksCarList =
        Arrays.stream(topRanksCarNames.split(",")).map(String::trim).toList();

    // 레이싱 경주할 차들 validation
    checkMatchWithGameMoney(carList, amount);
    checkDuplicatedName(carList);

    for (String car : carList) {
      super.validate(car);
      checkValidCarNameLength(car);
    }

    // 순위권 차들 validation
    checkRankedCarsLength(topRanksCarList);
    checkDuplicatedName(topRanksCarList);
    checkTopRankCarsInRaceCars(carList, topRanksCarList);
    for (String car : topRanksCarList) {
      super.validate(car);
      checkValidCarNameLength(car);
    }


    return new CarList(carList, topRanksCarList);
  }

}
