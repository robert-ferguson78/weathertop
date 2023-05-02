package Utilities;

import play.db.jpa.Model;

public class Conversions extends Model {
  public static String codeToText(int code) {
    switch (code) {
      case 100:
        return "Clear";
      case 200:
        return "Partial Clouds";
      case 300:
        return "Cloudy";
      case 400:
        return "Light Showers";
      case 500:
        return "Heavy Showers";
      case 600:
        return "Rain";
      case 700:
        return "Snow";
      case 800:
        return "Thunder";
      default:
        return "error";
    }
  }

  public static String codeToWeatherIcon(int code) {
    switch (code) {
      case 100:
        return "clear-day";
      case 200:
        return "cloud-up";
      case 300:
        return "cloudy";
      case 400:
        return "drizzle";
      case 500:
        return "extreme-rain";
      case 600:
        return "rain";
      case 700:
        return "snow";
      case 800:
        return "thunderstorms";
      default:
        return "star";
    }
  }

  public static float celsiusToFahrenheit(float temperature) {
    float fahrenheit = ((temperature * 9) / 5) + 32;
    return fahrenheit;
  }

  public static int kmHrToBeaufort(float windSpeed) {
    int beaufortScale = 0;
    if (windSpeed <= 1) {
      beaufortScale = 0;
    } else if (windSpeed > 1 && windSpeed <= 5) {
      beaufortScale = 1;
    } else if (windSpeed > 5 && windSpeed <= 11) {
      beaufortScale = 2;
    } else if (windSpeed > 11 && windSpeed <= 19) {
      beaufortScale = 3;
    } else if (windSpeed > 19 && windSpeed <= 28) {
      beaufortScale = 4;
    } else if (windSpeed > 28 && windSpeed <= 38) {
      beaufortScale = 5;
    } else if (windSpeed > 38 && windSpeed <= 49) {
      beaufortScale = 6;
    } else if (windSpeed > 49 && windSpeed <= 61) {
      beaufortScale = 7;
    } else if (windSpeed > 61 && windSpeed <= 74) {
      beaufortScale = 8;
    } else if (windSpeed > 74 && windSpeed <= 88) {
      beaufortScale = 9;
    } else if (windSpeed > 88 && windSpeed <= 102) {
      beaufortScale = 10;
    } else if (windSpeed > 102 && windSpeed <= 117) {
      beaufortScale = 11;
    }
    return beaufortScale;
  }

  public static String beaufortLabel(float windSpeed) {
    String beaufortScale = "";
    if (windSpeed <= 1) {
      beaufortScale = "Calm";
    } else if (windSpeed > 1 && windSpeed <= 5) {
      beaufortScale = "Light Air";
    } else if (windSpeed > 5 && windSpeed <= 11) {
      beaufortScale = "Light Breeze";
    } else if (windSpeed > 11 && windSpeed <= 19) {
      beaufortScale = "Gentle Breeze";
    } else if (windSpeed > 19 && windSpeed <= 28) {
      beaufortScale = "Moderate Breeze";
    } else if (windSpeed > 28 && windSpeed <= 38) {
      beaufortScale = "Fresh Breeze";
    } else if (windSpeed > 38 && windSpeed <= 49) {
      beaufortScale = "strong Breeze";
    } else if (windSpeed > 49 && windSpeed <= 61) {
      beaufortScale = "Near Gale";
    } else if (windSpeed > 61 && windSpeed <= 74) {
      beaufortScale = "Gale";
    } else if (windSpeed > 74 && windSpeed <= 88) {
      beaufortScale = "Severe Gale";
    } else if (windSpeed > 88 && windSpeed <= 102) {
      beaufortScale = "Strong storm";
    } else if (windSpeed > 102 && windSpeed <= 117) {
      beaufortScale = "Violent Storm";
    }
    return beaufortScale;
  }

}
