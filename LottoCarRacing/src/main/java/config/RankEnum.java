package config;

public enum RankEnum {
     FIRST(10), 
     SECOND(5),
     THIRD(3);
    
    private final int repeatCount;
     
    RankEnum(int repeatCount){
      this.repeatCount = repeatCount;
    }
    
    public void runTask(Runnable task) {
       for(int i =0; i< repeatCount; i++) {
         task.run();
       }
    }
      

}
