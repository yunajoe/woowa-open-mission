package model;

public class Car {
  private String name;
  private int forward;
  private int backward;
  private int stop;
  private int finalScore;


  public Car(String name) {
    this.name = name;
    this.forward = 0;
    this.backward = 0;
    this.stop = 0;
    this.finalScore = 0;

  }

  public void forwardCar() {
    forward++;
  }

  public void backwardCar() {
    backward++;
  }

  public void stopCar() {
    stop++;
  }

  public String getName() {
    return name;
  }

  public int getForward() {
    return forward;
  }

  public int getBackward() {
    return backward;
  }

  public int getStop() {
    return stop;
  }

  public int getFinalScore() {
    return finalScore;
  }

  public void setFinalScore(int finalScore){
    this.finalScore = finalScore;
  }


}
