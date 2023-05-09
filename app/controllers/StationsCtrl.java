package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationsCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Station id = " + id);
    render("stationsList.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, float windDirection) {
    Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection,  new Date());
    Station station = Station.findById(id);
    Logger.info("Add Readings");
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }

  public static void deleteReading(Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info("Removing " + reading.id);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    redirect("/stations/" + id);
  }

}
