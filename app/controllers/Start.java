package controllers;

import play.Logger;
import play.mvc.Controller;

public class Start extends Controller {
  // render start page
  public static void index() {
    Logger.info("Rendering Start");
    render("start.html");
  }
}
