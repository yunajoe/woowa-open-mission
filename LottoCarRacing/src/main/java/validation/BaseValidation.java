package validation;


public class BaseValidation {

  protected void checkNull(String str) {
    if (str == null) {
      throw new IllegalArgumentException("입력값이 null입니다.");
    }
  }

  protected void checkBlank(String str) {
    if (str.isBlank()) {
      throw new IllegalArgumentException("문자열이 비어있습니다.");
    }

  }

  protected void checkContainBlank(String str) {
    if (str.matches(".*\\s+.*")) {
      throw new IllegalArgumentException("문자열에 공백이 포함되어 있습니다.");
    }
  }

  protected int checkValidConvertedNumber(String str) {
    try {
      int num = Integer.parseInt(str);
      return num;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
  }


  public void validate(String str) {
    checkNull(str);
    checkBlank(str);
    checkContainBlank(str);
  }




}
