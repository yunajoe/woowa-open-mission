package service;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;

public class CarService {

     Car car = new Car();
  

     public void play() {
      // TODO Auto-generated method stub

       int num = Randoms.pickNumberInRange(0, 9);
       System.out.println(num);
     }



}
