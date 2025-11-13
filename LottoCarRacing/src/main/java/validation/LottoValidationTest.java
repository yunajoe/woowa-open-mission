package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidationTest {

  private final LottoValidation validation = new LottoValidation();


  @Test
  @DisplayName("정상 실행 테스트")
  void test_success() {

    String[] numbers = {"1", "2", "3", "4", "5", "6"};
    String bonusNum = "7";
    assertDoesNotThrow(() -> validation.lottoValidate(numbers, bonusNum));

  }


  @Test
  @DisplayName("빈 문자열 또는 공백 문자열 입력 시 예외 발생")
  void test_empty_shouldFail() {
    String[] numbers = {"", "2", "3", "4", "5", "6"};
    String bonusNum = "7";
    assertThatThrownBy(() -> validation.lottoValidate(numbers, bonusNum))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("문자열이 비어있습니다.");
  }

  @Test
  @DisplayName("null 입력시 예외 발생 ")
  void test_checkNull_shouldFail() {
    String[] numbers = {null, "2", "3", "4", "5", "6"};
    String bonusNum = "7";
    assertThatThrownBy(() -> validation.lottoValidate(numbers, bonusNum) )
        .isInstanceOf(IllegalArgumentException.class).hasMessage("입력값이 null입니다.");
  }



  @Test
  @DisplayName("숫자로 변환할 수 없는 문자열  입력 시 예외 발생")
  void test_invalidConvertedNumber_shouldFail() {
    String[] numbers = {"hi", "2", "3", "4", "5", "6"};
    String bonusNum = "7";
    assertThatThrownBy(() -> validation.lottoValidate(numbers, bonusNum))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("숫자를 입력해야 합니다.");
  }


  @Test
  @DisplayName("1~45 이외의 숫자  입력 시 예외 발생")
  void test_invalidNumberRange_shouldFail() {
    String[] numbers = {"0", "2", "3", "4", "5", "6"};
    String bonusNum = "7";
    assertThatThrownBy(() -> validation.lottoValidate(numbers, bonusNum))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("로또 번호는 1이상 45이하 여야 합니다.");
  }


  @Test
  @DisplayName("보너스 번호가 로또 번호와 중복시 예외 발생")
  void test_bonusNumber_In_lottoNumbers_shouldFail() {
    String[] numbers = {"1", "2", "3", "4", "5", "6"};
    String bonusNum = "6";
    assertThatThrownBy(() -> validation.lottoValidate(numbers, bonusNum))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("보너스 번호는 로또 번호와 중복되면 안됩니다.");
  }

}


