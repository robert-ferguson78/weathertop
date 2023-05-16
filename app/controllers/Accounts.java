package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class Accounts extends Controller {
  //  render signup page
  public static void signup() {
    Logger.info("User Sign up page");
    render("signup.html");
  }

  //  render login page
  public static void login() {
    Logger.info("Login page");
    render("login.html");
  }

  //  register user in system with check for unique email address
  public static void register(String firstname, String lastname, String email, String password) {
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

  //  render profile page
  public static void profile() {
    Member member = Accounts.getLoggedInMember();
    Logger.info("Rendering profile");
    render("profile.html", member);
  }

  //  update users profile information excluding email
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

  //  check users email and password for login and give error for incorrect login submission
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Login failed");
      String loginFail = "Login Failed please check email and password";
      render("/login.html", loginFail);
    }
  }

  //  log user out and send to root
  public static void logout() {
    session.clear();
    redirect("/");
  }

  //  get logged in member or send to login page
  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }

  // delete user-member from system
  public static void deleteAccount(Long memberID) {
    Member member = Accounts.getLoggedInMember();
    Logger.info("deleting account " + member.id);
    member.delete();
    session.clear();
    String deleteAccount = "Your account has been deleted";
    render("/signup.html", deleteAccount);
  }
}
