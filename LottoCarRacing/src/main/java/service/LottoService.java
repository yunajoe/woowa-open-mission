package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import config.LottoNumberEnum;
import config.LottoRankEnum;
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


  private LottoRankEnum getLottoRankByMatchedNumber(int correctLottoNumber,
      boolean correctBonusNumber) {
    if (correctLottoNumber == 6) {
      return LottoRankEnum.FIRST;
    }
    else if (correctLottoNumber == 5) {
      return LottoRankEnum.SECOND;
    }
    else if (correctLottoNumber == 5 && correctBonusNumber) {
      return LottoRankEnum.THIRD;
    }
    if (correctLottoNumber == 4) {
      return LottoRankEnum.FOURTH;
    }
    if (correctLottoNumber == 3) {
      return LottoRankEnum.FIFTH;
    }
    return LottoRankEnum.NONE;

  }


  public void winningLotto(List<RankCar> rankCars, LottoNumber lottoNumber) {

    List<Integer> lottoNums = lottoNumber.getNumbers();
    int bonusNum = lottoNumber.getBonusNumber();

    for (RankCar car : rankCars) {
      List<List<Integer>> lottos = car.getLottoNumber();
      List<Integer> lottorankingResults = new ArrayList<>();

      for (List<Integer> lotto : lottos) {
        List<Integer> commonNumbers = extractCommonElements(lotto, lottoNums);
        int correctLottoNumber = commonNumbers.size();
        boolean correctBonusNumber = lotto.contains(bonusNum);
        LottoRankEnum rankEnum = getLottoRankByMatchedNumber(correctLottoNumber, correctBonusNumber);


        lottorankingResults.add(rankEnum.getValue());

      }

       car.setLottoLanking(lottorankingResults);

    }


  }


}
