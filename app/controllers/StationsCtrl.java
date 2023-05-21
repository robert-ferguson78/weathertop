package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

import static controllers.Accounts.login;

public class StationsCtrl extends Controller {
  //  load list of stations
  public static void index(Long id) {
    if (session.contains("logged_in_Memberid")) {
      Member member = Accounts.getLoggedInMember();
      if (member != null) {
        Station station = Station.findById(id);
        boolean stationBelongToMember = member.stations.contains(station);
        if (stationBelongToMember) {
          render("stationslist.html", station);
        } else {
          flash("error", "You do not have permission to view this station");
          redirect("/dashboard");
        }
      }
    } else {
      login();
    }
  }

  //  add reading to station
  public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, float windDirection) {
    Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection, new Date());
    Station station = Station.findById(id);
    Logger.info("Add Readings");
    station.readings.add(reading);
    station.save();
    redirect("/stations/" + id);
  }

  //  delete reading attached to station
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
