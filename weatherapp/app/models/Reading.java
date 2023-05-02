package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reading extends Model
{
  public int code;
  public float temperature;
  public float windSpeed;
  public int pressure;

  public Reading(int code, float temperature, float windSpeed, int pressure)
  {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
  }


  //getters
  public int getCode() {
    return code;
  }
  public float getTemperature() {
    return temperature;
  }
  public float getWindSpeed() {
    return windSpeed;
  }
  public int getPressure() {
    return pressure;
  }

  //setters
  public void setCode(int code) {
    this.code = code;
  }
  public void setTemperature(float temperature) {
    this.temperature = temperature;
  }
  public void setWindSpeed(float windSpeed) {
    this.windSpeed = windSpeed;
  }
  public void setPressure(int pressure) {
    this.pressure = pressure;
  }
}