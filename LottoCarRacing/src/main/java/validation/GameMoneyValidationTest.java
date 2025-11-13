package validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameMoneyValidationTest {

  private final GameMoneyValidation validation = new GameMoneyValidation();

  @Test
  void test_success_case() {
    String input = "5000";
    validation.validate(input);
  }


  @ParameterizedTest
  @ValueSource(strings = {"", "     "})
  @DisplayName("빈 문자열 또는 공백 문자열 입력 시 예외 발생")
  void test_invalidInput_shouldFail(String input) {
    assertThatThrownBy(() -> validation.gameMoneyValidate(input))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("문자열이 비어있습니다.");
  }


  @ParameterizedTest
  @ValueSource(strings = {"test", "!@#$", "1test"})
  @DisplayName("숫자로 변환할 수 없는 문자열  입력 시 예외 발생")
  void test_invalidConvertedNumber_shouldFail(String input) {
    assertThatThrownBy(() -> validation.gameMoneyValidate(input))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("숫자를 입력해야 합니다.");
  }



  @ParameterizedTest
  @ValueSource(strings = {"1000", "2000", "200000"})
  @DisplayName("3000원 미만 입력 시 예외 발생")
  void test_under3000_shouldFail(String input) {
    assertThatThrownBy(() -> validation.gameMoneyValidate(input))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("최소 5000 최대 100000 입력해야 합니다.");
  }

  @ParameterizedTest
  @ValueSource(strings = {"5123", "55123"})
  @DisplayName("1000원으로 나누어 떨어지지 않으면 예외 발생")
  void test_invalidC_shouldFail(String input) {
    assertThatThrownBy(() -> validation.gameMoneyValidate(input))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("1000으로 나누었을 때 0으로 떨어져야 합니다.");
  }
}
