package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationsCtrl extends Controller
{
  public static void index(Long id)
  {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    render("stationsList.html", station);
  }
  public static void addStation(String name) {
    Station station = new Station(name, 0);
    Logger.info("Adding a New Station Called " + name);
    station.save();
    redirect("/dashboard");
  }

  public static void addReading(Long id, int code, float temperature, float windSpeed, int pressure, float windDirection) {
    Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection);
    Station station = Station.findById(id);
    Logger.info("Add Readings");
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }
}
