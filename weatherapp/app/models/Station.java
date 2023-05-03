package models;

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
  public double latitude;
  public double longitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude, int i) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
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

  public double celsiusToFahrenheit(){
    double celsius = readings.get(readings.size() - 1).getTemperature();
    double fahrenheit = Conversions.celsiusToFahrenheit(celsius);
    return fahrenheit;
  }

  public int kmHrToBeaufortScale(){
    double windspeed = readings.get(readings.size() - 1).getWindSpeed();
    int beaufort = Conversions.kmHrToBeaufort(windspeed);
    return beaufort;
  }

  public String windCompassDirection(){
    float windDirection = readings.get(readings.size() - 1).getWindDirection();
    String compassText = Conversions.windCompassReading(windDirection);
    return compassText;
  }

  public double windChill(){
    double windspeed = readings.get(readings.size() - 1).getWindSpeed();
    double celsius = readings.get(readings.size() - 1).getTemperature();
    double windChill = Conversions.calculateWindChill(celsius, windspeed);
    return windChill;
  }

  public String beaufortLabel(){
    double windspeed = readings.get(readings.size() - 1).getWindSpeed();
    String beaufortLabel = Conversions.beaufortLabel(windspeed);
    return beaufortLabel;
  }

  public int currentPressure() {
    int pressure = readings.get(readings.size() - 1).getPressure();
    return pressure;
  }

}
