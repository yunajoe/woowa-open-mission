package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;
import config.LottoNumberEnum;
import config.RankEnum;
import model.RankCar;



public class LottoService {

  int MIN_VALUE = LottoNumberEnum.MIN_VALUE.getValue();
  int MAX_VALUE = LottoNumberEnum.MAX_VALUE.getValue();
  int SIZE = LottoNumberEnum.SIZE.getValue();

  RankEnum first = RankEnum.FIRST;


  protected List<Integer> lottoNumberGenerate() {
    return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, SIZE);

  }

  protected List<List<Integer>> generateLottoNumbersByRank(int rank) {
    RankEnum rankEnum = null;
    if (rank == 1)
      rankEnum = RankEnum.FIRST;
    else if (rank == 2)
      rankEnum = RankEnum.SECOND;
    else if (rank == 3)
      rankEnum = RankEnum.THIRD;

    List<List<Integer>> numbersByRank = new ArrayList<>();

    if (rankEnum != null) {
      rankEnum.runTask(() -> {
        List<Integer> numbers = lottoNumberGenerate();
        numbersByRank.add(numbers);
      });
    }

    return numbersByRank;

  }

  public Map<RankCar, List<List<Integer>>> run(List<RankCar> rankCars) {

    Map<RankCar, List<List<Integer>>> allNumbers = new HashMap<>();
    for (RankCar car : rankCars) {
      int rank = car.getRanking();
      List<List<Integer>> numbers = generateLottoNumbersByRank(rank);
      allNumbers.put(car, numbers);
      

    }  
    return allNumbers;
  }


}
