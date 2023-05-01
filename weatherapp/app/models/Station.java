package models;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Utilities.Conversions;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name) {
    this.name = name;
  }

  //current weather reading methods
  public String currentWeatherCode(){
  //int number = readings.get(readings.size() - 1).getCode();
    //String codeText = Conversions.codeToText(number);
    return Conversions.codeToText(readings.get(readings.size() - 1).getCode());
  }

  public String currentWeatherCodeIcon(){
    int number = readings.get(readings.size() - 1).getCode();
    String codeToWeatherIcon = Conversions.codeToWeatherIcon(number);
    return codeToWeatherIcon;
  }

  public float celsiusToFahrenheit(){
    float celsius = readings.get(readings.size() - 1).getTemperature();
    float fahrenheit = Conversions.celsiusToFahrenheit(celsius);
    return fahrenheit;
  }

  public int kmHrToBeaufortScale(){
    float windspeed = readings.get(readings.size() - 1).getWindSpeed();
    int beaufort = Conversions.kmHrToBeaufort(windspeed);
    return beaufort;
  }

  public String beaufortLabel(){
    float windspeed = readings.get(readings.size() - 1).getWindSpeed();
    String beaufortLabel = Conversions.beaufortLabel(windspeed);
    return beaufortLabel;
  }

  public int currentPressure() {
    int pressure = readings.get(readings.size() - 1).getPressure();
    return pressure;
  }

}
