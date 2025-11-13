package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import config.LottoNumberEnum;
import config.RankEnum;
import model.LottoNumber;
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
    if (rank == 1) {
      rankEnum = RankEnum.FIRST;
    } else if (rank == 2) {
      rankEnum = RankEnum.SECOND;
    } else if (rank == 3) {
      rankEnum = RankEnum.THIRD;
    }

    List<List<Integer>> numbersByRank = new ArrayList<>();

    if (rankEnum != null) {
      rankEnum.runTask(() -> {
        List<Integer> numbers = lottoNumberGenerate();
        numbersByRank.add(numbers);
      });
    }

    return numbersByRank;

  }


//
//  public Map<RankCar, List<List<Integer>>> run(List<RankCar> rankCars) {
//
//    Map<RankCar, List<List<Integer>>> allNumbers = new HashMap<>();
//    for (RankCar car : rankCars) {
//      int rank = car.getRanking();
//      List<List<Integer>> numbers = generateLottoNumbersByRank(rank);
//      allNumbers.put(car, numbers);
//
//    }
//    return allNumbers;
//  }


  public void run(List<RankCar> rankCars) {
    for (RankCar car : rankCars) {
      int rank = car.getRanking();
      List<List<Integer>> numbers = generateLottoNumbersByRank(rank);
      car.setLottoNumbers(numbers);
    }

  }
  protected List<Integer> extractCommonElements(List<Integer> randomLotto,
      List<Integer> inputLotto) {
    List<Integer> commonElements =
        randomLotto.stream().filter(inputLotto::contains).collect(Collectors.toList());
    return commonElements;
  }



  // TODO: 로또 위너 로직 구현하
  public void winningLotto(List<RankCar> rankCars, LottoNumber lottoNumber) {

    List<Integer> lottoNums = lottoNumber.getNumbers();
    int bonusNum = lottoNumber.getBonusNumber();

    System.out.println("선택한 로또 넘버 ===>" + lottoNums);
    System.out.println("선택한 보너스 넘버 ===>" + bonusNum);

    for (RankCar car : rankCars) {
      List<List<Integer>> lottos = car.getLottoNumber();
      System.out.println("randomLottos ===>"+ lottos);
//      List<List<Integer>> lottos = lottoResults.get(car);
//
//      for (List<Integer> lotto : lottos) {
//        List<Integer> commonNumbers = extractCommonElements(lotto, lottoNums);
//        System.out.println("공통 요소" + commonNumbers);
//        int correctNumber = commonNumbers.size();
//
//
//
//      }


    }


  }


}
