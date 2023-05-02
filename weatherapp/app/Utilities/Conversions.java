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

  public static double celsiusToFahrenheit(double temperature) {
    double fahrenheit = ((temperature * 9) / 5) + 32;
    return fahrenheit;
  }

  public static int kmHrToBeaufort(double windSpeed) {
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

  public static String beaufortLabel(double windSpeed) {
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

  public static String windCompassReading(double degreeToConvert) {
    String windDirectionText = "";
    if ((degreeToConvert > 348.75 && degreeToConvert <= 360) || (degreeToConvert >= 0 && degreeToConvert <= 11.25)) {
      windDirectionText = "North";
    } else if (degreeToConvert > 11.25 && degreeToConvert <= 33.75) {
      windDirectionText = "North North East";
    } else if (degreeToConvert > 33.75 && degreeToConvert <= 56.25) {
      windDirectionText = "North East";
    } else if (degreeToConvert > 56.25 && degreeToConvert <= 78.75) {
      windDirectionText = "East North East";
    } else if (degreeToConvert > 78.75 && degreeToConvert <= 101.25) {
      windDirectionText = "East";
    } else if (degreeToConvert > 101.25 && degreeToConvert <= 123.75) {
      windDirectionText = "East South East";
    } else if (degreeToConvert > 123.75 && degreeToConvert <= 146.25) {
      windDirectionText = "South East";
    } else if (degreeToConvert > 146.25 && degreeToConvert <= 168.75) {
      windDirectionText = "South South East";
    } else if (degreeToConvert > 168.75 && degreeToConvert <= 191.25) {
      windDirectionText = "South";
    } else if (degreeToConvert > 191.25 && degreeToConvert <= 213.75) {
      windDirectionText = "South South West";
    } else if (degreeToConvert > 213.75 && degreeToConvert <= 236.25) {
      windDirectionText = "South West";
    } else if (degreeToConvert > 236.25 && degreeToConvert <= 258.75) {
      windDirectionText = "West South West";
    } else if (degreeToConvert > 258.75 && degreeToConvert <= 281.25) {
      windDirectionText = "West";
    } else if (degreeToConvert > 281.25 && degreeToConvert <= 303.75) {
      windDirectionText = "West North West";
    } else if (degreeToConvert > 303.75 && degreeToConvert <= 326.25) {
      windDirectionText = "North West";
    } else if (degreeToConvert > 326.25 && degreeToConvert <= 348.75) {
      windDirectionText = "North North West";
    } else {
      windDirectionText = "Error";
    }
    return windDirectionText;
  }

  public static double calculateWindChill(double temperature, double windSpeed) {
    double windChill;
    windChill = 13.12 + (0.6215 * temperature) - 11.37 * (Math.pow(windSpeed, 0.16))
        + (0.3965 * temperature) * (Math.pow(windSpeed, 0.16));
    return Math.round(windChill * 100.0) / 100.0;
  }

}
