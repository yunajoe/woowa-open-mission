package service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import model.Car;

public class CarService {


  final int round = 10;
  
  RacingService racingService = new RacingService();

  protected List<Car> makeCarInstance(List<String> carNames) {

    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return cars;

  }


 // TODO:최동 값이 같으면은 전진 횟수 비교를 해서 더 큰 걸 우선순위
  // 그래도 같으면은 후진 횟수를 비교를 해서 작은걸 우선순위로 한다.
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
    racingService.run(instanceCars);
    sortByAsendingFinalScore(instanceCars);
    return instanceCars;

  }



}
