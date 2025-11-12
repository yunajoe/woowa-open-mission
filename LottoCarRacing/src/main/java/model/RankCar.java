package model;

public class RankCar {
   private String name;
   private int ranking;
   
   
   public RankCar(String name, int ranking){
       this.name = name;
       this.ranking = ranking;
     
   }
   
  public String getName(){
    return name;
    
  }
  
  public int getRanking(){
    return ranking;  
  }
    
   

}
