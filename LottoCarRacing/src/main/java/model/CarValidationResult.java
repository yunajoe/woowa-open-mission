package model;

import java.util.List;

public class CarValidationResult {
  private List<String> carList;
  private List<String> topRanksCarList;


  public CarValidationResult(List<String> carList, List<String> topRanksCarList) {
    this.carList = carList;
    this.topRanksCarList = topRanksCarList;
  }

  public List<String> getCarList() {
    return carList;
  }

  public List<String> getTopRanksCarList() {
    return topRanksCarList;
  }


}
