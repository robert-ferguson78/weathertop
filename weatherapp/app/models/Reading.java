package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reading extends Model
{
  public int code;
  public double temperature;
  public double windSpeed;
  public int pressure;
  public float windDirection;

  public Reading(int code, double temperature, double windSpeed, int pressure, float windDirection)
  {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }


  //getters
  public int getCode() {
    return code;
  }
  public double getTemperature() {
    return temperature;
  }
  public double getWindSpeed() {
    return windSpeed;
  }
  public int getPressure() {
    return pressure;
  }
  public float getWindDirection() { return windDirection;}

  //setters
  public void setCode(int code) {
    this.code = code;
  }
  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }
  public void setWindSpeed(float windSpeed) {
    this.windSpeed = windSpeed;
  }
  public void setPressure(int pressure) {
    this.pressure = pressure;
  }
  public void setWindDirection(float windDirection) {
    this.windDirection = windDirection;
  }
}