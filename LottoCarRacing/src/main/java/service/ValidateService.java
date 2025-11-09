package service;

public class ValidateService  {
	
	
	public boolean checkEmpty(String str) {
		return str.isEmpty();
	}
	
  public boolean checkValidCarNameLengh(String str) {
  	return str.length() >=1 && str.length() <=10;
  }
  
  public boolean checkContainBlankRegex(String str) {
    String regex = ".*\\s+.*";
  	return str.matches(regex);
  }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
