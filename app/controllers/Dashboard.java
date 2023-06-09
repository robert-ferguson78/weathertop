package controllers;

import java.util.List;

import Utilities.Conversions;
import models.Member;
import models.Station;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
  // render dashboard
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Conversions.sortStations(member.stations);
    render("dashboard.html", stations);
  }

  // add station to member
  public static void addStation(String name, double latitude, double longitude) {
    Logger.info("Adding a New Station Called " + name);
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, latitude, longitude, 0);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }

  // delete station attached to member
  public static void deleteStation(Long id) {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }
}

