package config;


public enum GameMoneyEnum {
  UNIT(1000), MIN_VALUE(3000), MAX_VALUE(10000);


  private final int value;


  GameMoneyEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }


}
