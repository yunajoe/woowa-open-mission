package config;

public enum CarEnum {

  NAME_MIN_LENGTH(1), NAME_MAX_LENGTH(5), NUMBER_OF_RANK_CAR(3);

  private final int value;

  CarEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }


}
