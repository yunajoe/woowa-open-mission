package config;

public enum LottoRankEnum {
  FIRST(1, 2000000000), SECOND(2, 30000000), THIRD(3, 1500000), FOURTH(4, 50000), FIFTH(5,
      5000), NONE(0, 0);

  private final int value;
  private long prizeAmount;

  LottoRankEnum(int value, long prizeAmount) {
    this.value = value;
    this.prizeAmount = prizeAmount;

  }

  public int getValue() {
    return value;
  }

  public long getPrizeAmount() {
    return prizeAmount;

  }

  public static long getPrizeAmountFromRank(int rank) {
    for (LottoRankEnum ranks : values()) {
      if (ranks.value == rank) {
        return ranks.getPrizeAmount();
      }

    }
    return 0;
  }
}
