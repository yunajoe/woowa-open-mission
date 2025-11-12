package service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import model.RankCar;

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


  protected void sortByAsendinConditions(List<Car> cars) {
    cars.sort(Comparator.comparingInt(Car::getFinalScore).reversed() // finalScore 내림차순
        .thenComparing(Comparator.comparingInt(Car::getForward).reversed()) // forward 내림차순
        .thenComparing(Comparator.comparingInt(Car::getBackward)) // backward 오름차순
        .thenComparing(Comparator.comparingInt(Car::getStop).reversed())//  stop 내림차순 
        .thenComparing(Car::getName) // 이름 오름차순 
    );
  }



  public List<Car> run(List<String> cars) {
    List<Car> instanceCars = makeCarInstance(cars);
    racingService.run(instanceCars);
    sortByAsendinConditions(instanceCars);
    return instanceCars;

  }

  public List<RankCar> runTopRanksCars(List<Car> cars, List<String> topRanksCars) {
     int limit  = Math.min(3,  cars.size());
     
     List<Car> firstThreeCars = new ArrayList<>(cars.subList(0, limit));
     
     List<RankCar> rankCars = new ArrayList<>();
     
     for(int i=0; i < firstThreeCars.size(); i++) {
       Car car  = firstThreeCars.get(i);
       if(topRanksCars.contains(car.getName())){
         rankCars.add(new RankCar(car.getName(), i + 1));
       }
       
     }
     return rankCars;  
     
     
  }


}
