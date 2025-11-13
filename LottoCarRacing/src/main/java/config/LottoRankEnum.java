package config;

public enum LottoRankEnum {
  FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), NONE(0);
  
  private final int value; 
  
  LottoRankEnum(int value){
    this.value = value;

  }

  public int getValue() {
      return value;
  }
}
