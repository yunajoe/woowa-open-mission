package config;

public enum LottoNumberEnum {
  SIZE(6), MIN_VALUE(1), MAX_VALUE(45);

  private final int value;

  LottoNumberEnum(int value){
    this.value = value;
  }

  public int getValue(){
    return value;
  }
}
