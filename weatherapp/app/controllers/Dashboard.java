package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  public static void addStation(String name) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, 0);
    Logger.info("Adding a New Station Called " + name);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }
}

