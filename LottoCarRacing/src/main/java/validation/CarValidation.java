package validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarValidation extends BaseValidation {

	protected void checkValidCarNameLengh(String str) {
		boolean isValid = str.length() >= 1 && str.length() <= 5;
		if (!isValid) {
			throw new IllegalArgumentException("최소 길이는 1 최대 길이는 5입니다.");
		}
	}

	protected void checkMatchWithGameMoney(List<String> carNames, int gameMoney) {
		int carCount = gameMoney / 1000;
		System.out.println("CARCOUNT ==>" + carCount);
		boolean isValid = carNames.size() == carCount;
		if (!isValid) {
			throw new IllegalArgumentException("입력한 금액에 맞는 자동차 갯수를 입력해야 합니다.");
		}

	}

	@Override
	public void validate(String str) {
		super.validate(str);
		System.out.println("str ===>>" + str);
		String[] splitedCar = str.split(",");

		// 배열을 List로 변환
		List<String> list = Arrays.asList(splitedCar);

		System.out.println("LIST" + list);

		list.forEach(item -> {
			String car = item.trim();
			System.out.println("car ===>>" + car);
			checkValidCarNameLengh(car);

			super.checkNull(car);
			super.checkEmpty(car);
			super.checkContainBlank(car);
			checkValidCarNameLengh(car);

		});

	}

	public void carValidate(String str, int amount) {
		super.validate(str);
		String[] splitedCar = str.split(",");

		// 배열을 List로 변환
		List<String> list = Arrays.asList(splitedCar);

		System.out.println("LIST" + list);
		checkMatchWithGameMoney(list, amount);

	}

}
