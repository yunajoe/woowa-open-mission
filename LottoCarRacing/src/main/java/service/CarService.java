package service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import model.Car;

public class CarService {


  final int round = 10;



  protected List<Car> makeCarInstance(List<String> carNames) {

    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return cars;

  }


  protected void racing(List<Car> cars) {
    for (int i = 1; i <= round; i++) {
      for (Car car : cars) {
        int num = Randoms.pickNumberInRange(0, 9);
        calculateRacingScore(car, num);
      }
    }
  }

  protected void calculateRacingScore(Car car, int num) {
    if (num >= 5 && num <= 9) {
      car.forwardCar();
    } else if (num >= 1 && num <= 5) {
      car.backwardCar();
    } else if (num == 0) {
      car.stopCar();
    }
  }
  
 protected void sortByAsendingFinalScore(List<Car> cars) {
    cars.sort((a,b) -> b.getFinalScore() - a.getFinalScore());
 }



  protected void calculateWinners(List<Car> cars) {
    for (Car car : cars) {
      String carName = car.getName();
      int forwardCount = car.getForward();
      int backwardCount = car.getBackward();
      int stopCount = car.getStop();
      int result = forwardCount - backwardCount;
      car.setFinalScore(result);

    }

  }

  public List<Car> run(List<String> cars) {
    List<Car> instanceCars = makeCarInstance(cars);
    racing(instanceCars);
    calculateWinners(instanceCars);
    sortByAsendingFinalScore(instanceCars);
    return instanceCars;

  }



}
