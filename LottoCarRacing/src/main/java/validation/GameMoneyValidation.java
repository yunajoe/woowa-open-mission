package validation;

public class GameMoneyValidation extends BaseValidation {
	
	
	
// TODO: max 금액 정하기 
	protected void checkGameMoneyAmount(int amount) {
		if(amount < 3000) {
      throw new IllegalArgumentException("3000원 이상으로 입력해야 합니다.");
		}
	}
	
	protected int checkValidConvertedNumber(String str) {
	   try {
	  	 int amount = Integer.parseInt(str);
       System.out.println("입력한 " + amount);
       return amount;
	   } catch (NumberFormatException e) {
       throw new IllegalArgumentException("숫자를 입력해야 합니다."); 
    }


	}

	
  @Override
	public  void  validate(String str) {
      super.validate(str);
  		int amount = checkValidConvertedNumber(str);
  		checkGameMoneyAmount(amount);
		
	}
	
	
	


}
