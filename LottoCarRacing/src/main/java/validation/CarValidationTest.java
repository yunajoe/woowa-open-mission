package validation;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarValidationTest {

  private final CarValidation validation = new CarValidation();
  
  @Test
  @DisplayName("정상 입력 시 통과")
  void test_carValidate_success() {
    String carNames = "car1,car2,car3";
    int amount = 3000;

    assertThatCode(() -> validation.carValidate(carNames, amount))
        .doesNotThrowAnyException();
  }

  @Test
  @DisplayName("자동차 이름이 null 값일 경우 예외 발생")
  void test_checkNull_shouldFail() {
      assertThatThrownBy(() -> validation.checkNull(null))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("입력값이 null입니다.");
  }


  @ParameterizedTest
  @DisplayName("금액과 자동차 개수가 맞지 않으면 예외 발생")
  @ValueSource(ints = {1000, 2000, 4000})
  void test_notMatchCount_variousMoney_shouldFail(int gameMoney) {
    List<String> carNames = List.of("a", "b", "c");

    assertThatThrownBy(() -> validation.checkMatchWithGameMoney(carNames, gameMoney))
        .isInstanceOf(IllegalArgumentException.class).hasMessage("입력한 금액에 맞는 자동차 갯수를 입력해야 합니다.");
  }
  
  
  @ParameterizedTest
  @ValueSource(strings = {"abcefgh", "car123456"})
  @DisplayName("자동차 이름 길이 검증")
  void test_checkValidCarNameLength_shouldFail(String input) {
    assertThatThrownBy(() -> validation.checkValidCarNameLength(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름 길이는 최소 한글자 최대 다섯글자입니다.");
  }
  
  @Test
  @DisplayName("금액과 자동차 수 불일치 시 예외 발생")
  void test_carValidate_mismatchCount_shouldFail() {
    String carNames = "car1,car2"; 
    int amount = 3000; 

    assertThatThrownBy(() -> validation.carValidate(carNames, amount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("입력한 금액에 맞는 자동차 갯수를 입력해야 합니다.");
  }
  
  @Test
  @DisplayName("자동차 이름 길이가 1~5 범위가 아닐 경우 예외 발생")
  void test_carValidate_nameTooLong_shouldFail() {
    String carNames = "car123456,car1,car2"; 
    int amount = 3000;

    assertThatThrownBy(() -> validation.carValidate(carNames, amount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("자동차 이름 길이는 최소 한글자 최대 다섯글자입니다.");
  }
  
 
  
  @Test
  @DisplayName("자동차 이름이 빈 문자열일 경우 예외 발생")
  void test_carValidate_blankName_shouldFail() {
    String carNames = "car1, ,car2"; 
    int amount = 3000;

    assertThatThrownBy(() -> validation.carValidate(carNames, amount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("문자열이 비어있습니다.");
  }
  
  @Test
  @DisplayName("자동차 이름이 중복일 경우 예외 발생")
  void test_carValidate_duplicateName_shouldFail() {
    String carNames = "car1,car1,car2"; 
    int amount = 3000;

    assertThatThrownBy(() -> validation.carValidate(carNames, amount))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("중복된 자동차 이름은 입력할 수 없습니다.");
  }
  

  
  
}
