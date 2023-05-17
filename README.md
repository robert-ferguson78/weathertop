# WeatherTop Assignment

Student Name : Robert Ferguson
Student Number : 20104121
GitHub URL: https://github.com/robert-ferguson78/weathertop
Deploy URL : https://app-76c5944d-5edf-4a8e-9d2c-b1587ad55e49.cleverapps.io/
YouTube :

This is WeatherTop Release 3 of the joint assignment of Web & Programming

Features that have been implemented from the assignment brief

* Initial values are read in from YAML file to save in Database
  * Station 
    * Name
    * Latitude
    * Longitude
    * attached readings
  * Station Readings
    * Date
    * Code
    * Temperature
    * WindSpeed
    * WindDirection
    * Pressure
  * Member/User
    * Email
    * First Name
    * Last Name
    * Password
    * Stations
* User visits site and has option to login or Signup/Register
* Users Readings are displayed which contain 
  * Date of reading created
  * Weather Code
  * Temperature
  * WindSpeed
  * WindDirection
  * Pressure
* Temperature is converted and displayed in both C & F
* WindSpeed is converted in Beaufort scale to user, and also accompanied by text description of Beaufort number
* WindDirection is converted from 0-360 value range to compass direction eg:"North East"
* WindSpeed is converted to WindChill
* Ability to add new stations "Unlimited Stations" attached to logged in Member, add station form accepts Name, Lat "
  limited values between -90 to 90" and Long "limited values between -180 to 180" for new station entry
* Ability to add new Readings "Unlimited readings", Date is auto assigned with user form submission of Weather Code,
  Temperature, WindSpeed "limited values between 0 to 117", WindDirection "limited values between 0 to 360", Pressure
* Ability to delete stations attached to logged in Member/User
* Ability to delete Readings attached to stations
* Stations listed in alphabetical order in Station list view
* Seperated Station and Reading views
* Latest readings has Weather icons assigned
  * Location
  * Weather Code
  * Temperature
  * Wind
  * Pressure
* Min and Max values are displayed for
  * Temperature
  * Wind
  * Pressure
* Trends are displayed for Temperature, Wind, Pressure with icons and text for values Falling, Stable and Rising based
  on last 3 readings from user
* Member/User profile page to display user details including 
  * Email
  * First Name
  * Last Name
  * Password "password is hidden with ***"
* Ability to update users profile for
  * First Name
  * Last Name
  * Password
  * But email is unique identifier for account and can not be changed "this is by design"
* Ability to delete Member/User from application

Additional Features that have been implemented

* Custom 404 page
* Required added to form fields to ensure values for Stations, Readings and Member/User profile data
* Duplicate password fields to check for matching passwords "type in password twice to avoid typos" on both registration
  and profile update page
* User confirmation for data deletion "Cancel and Confirm Deletion" on Station, Reading and Member/User deletion
* User confirmation messages for Profile update successful, account deletion, Login failed, duplicate email address
* New station created with alternative message of "No Readings" for values not present in Readings
* Latest Readings not displayed in Reading list view until 1 reading is added
* Trends only display when 3 readings are entered
* Custom icons added for all readings and calculated reading data
* Min and Max values assigned to form inputs to keep data within required data value ranges
* Iframe video of weather forcast data on home page
* Main menu is swapped for logged in menu on home page based on Session "logged_in_Memberid"
* Animated icons for latest readings with wind icon animation speed + number based on Beaufort scale value