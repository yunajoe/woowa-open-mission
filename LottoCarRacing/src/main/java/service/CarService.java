package service;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import model.Car;

public class CarService {


  final int round = 10;



  public List<Car> makeCarInstance(List<String> carNames) {

    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return cars;

  }


  protected void calculateRacing(Car car, int num) {
    if (num >= 5 && num <= 9) {
      car.forwardCar();
    } else if (num >= 1 && num <= 5) {
      car.backwardCar();
    } else if (num == 0) {
      car.stopCar();
    }
  }



  public void play(List<Car> cars) {
    for (int i = 1; i <= round; i++) {
      for (Car car : cars) {
        int num = Randoms.pickNumberInRange(0, 9);
        calculateRacing(car, num);
      }
    }
  }
  
 public void calculateRacing(List<Car> cars){
    for(Car car : cars) {
      String carName = car.getName();
      int forwardCount = car.getForward();
      int backwardCount = car.getBackward();
      int stopCount = car.getStop();
      int result = forwardCount - backwardCount;
      car.setFinalScore(result);
      System.out.println(car.getName() + " -> result: " + car.getFinalScore());

    }
   
 }



}
