package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Stations extends Controller
{
  public static void index() {
    Logger.info("Rendering stations");
    render ("stations.html");
  }
}

