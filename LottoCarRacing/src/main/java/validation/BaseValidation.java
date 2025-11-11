package validation;

// private는 같은 클래스에서마 사용가
// protected 메서드는 같은 패키지혹은 상속을 받은 곳에서 오버라이딩 오버로드 가능하다.
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

  public void validate(String str) {

    checkNull(str);
    checkBlank(str);
    checkContainBlank(str);

  }



}
