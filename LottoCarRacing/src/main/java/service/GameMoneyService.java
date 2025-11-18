package service;

import java.util.List;
import config.GameMoneyEnum;
import config.LottoRankEnum;
import jakarta.servlet.http.HttpServletRequest;
import model.RankCar;

public class GameMoneyService {
  // 보유한 game Money에서 경주할 자동차 이름의 갯수 & 1000 를 빼고 다시 gameMoney속성에 저장해주자
  int UNIT = GameMoneyEnum.UNIT.getValue();


  public void calculateGameMoneyWithRacingCars(HttpServletRequest request, long gameMoney,
      List<String> cars) {
    long REMAINING_GAME_MONEY = gameMoney - cars.size() * UNIT;
    request.getSession().setAttribute("gameMoney", REMAINING_GAME_MONEY);

  }

  public void calculateGameMoneyWithLotto(HttpServletRequest request, long gameMoney, List<RankCar> rankCars) {
    // 현재 보유하고 있는 게임 머니에 등수 결과에 따라 돈을 다시 add up 해준다.
    long TOTAL_PRIZE_SUM = 0;
    for (RankCar car : rankCars) {
      List<Integer> lottoRanking = car.getLottoRanking();
      System.out.println("랭킹 ===>>" + lottoRanking);
      for (int rank : lottoRanking) {
        long prize = LottoRankEnum.getPrizeAmountFromRank(rank);
        TOTAL_PRIZE_SUM += prize;
      }
    }
    System.out.println(" 총 합  ===>" +  TOTAL_PRIZE_SUM);
    request.getSession().setAttribute("gameMoney", TOTAL_PRIZE_SUM);


  }



}
