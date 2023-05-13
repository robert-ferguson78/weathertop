package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller
{
  public static void signup()
  {
    Logger.info("User Sign up page");
    render("signup.html");
  }

  public static void login()
  {
    Logger.info("Login page");
    render("login.html");
  }

  public static void register(String firstname, String lastname, String email, String password)
  {
    Member checkEmail = Member.findByEmail(email);
    if (checkEmail == null) {
      Logger.info("Registering new user " + email);
      Member member = new Member(firstname, lastname, email, password);
      member.save();
      redirect("/login");
    } else {
      Logger.info("Duplicate email address");
      String duplicateEmail = "This email address has already been registered, please use a different email to register account";
      render("/signup.html", duplicateEmail);
    }

  }

  public static void profile() {
    Member member = Accounts.getLoggedInMember();
    Logger.info("Rendering profile");
    render("profile.html", member);
  }

  public static void profileUpdate(Long memberId, String firstname, String lastname, String password) {
    Member member = Member.findById(memberId);
    member.setFirstName(firstname);
    member.setLastName(lastname);
    member.setPassword(password);
    member.save();
    Logger.info("User updated profile Name " + member.getFirstName() + " " + member.lastname + " password " + member.password);
    String message = "Profile Updated Sucessfully";
    render("/profile.html", member, message);
  }

  public static void authenticate(String email, String password)
  {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect ("/dashboard");
    } else {
      Logger.info("Login failed");
      String loginFail = "Login Failed please check email and password";
      render("/login.html", loginFail);
    }
  }

  public static void logout()
  {
    session.clear();
    redirect ("/");
  }

  public static Member getLoggedInMember()
  {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }
}
