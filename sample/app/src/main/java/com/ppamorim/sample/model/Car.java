package com.ppamorim.sample.model;

/**
 * Created by pedro on 2/14/15.
 */
public class Car {

  private int id;
  private String name;

  public Car(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
