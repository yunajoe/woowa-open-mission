package model;

import java.util.List;

public class RankCar {
  private String name;
  private int ranking;

  private List<List<Integer>> lottoNumbers;
  private List<Integer> lottoRanking;



  public RankCar(String name, int ranking) {
    this.name = name;
    this.ranking = ranking;

  }

  public String getName() {
    return name;

  }

  public int getRanking() {
    return ranking;
  }

  public List<List<Integer>> getLottoNumber() {
    return lottoNumbers;

  }

  public void setLottoNumbers(List<List<Integer>> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<Integer> getLottoRanking() {
    return lottoRanking;
  }

  public void setLottoResults(List<Integer> lottoRanking) {
    this.lottoRanking = lottoRanking;
  }



}
