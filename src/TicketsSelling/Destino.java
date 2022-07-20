package TicketsSelling;

public class Destino {
  String cityName;
  String cityCode;
  int numberSeats;
  int price;
  String dateToTravel;

  public Destino(String destinyInfoLine, int numberSeats, String dateToTravel) {
    String[] destinyInfo = destinyInfoLine.split("/");
    this.cityName = destinyInfo[0];
    this.cityCode = destinyInfo[1];
    this.numberSeats = numberSeats;
    this.price = (numberSeats > 4 ? Integer.parseInt(destinyInfo[4]) : Integer.parseInt(destinyInfo[3])) * numberSeats;
    this.dateToTravel = dateToTravel;
  }

  public String getCityName() {
    return cityName;
  }

  public String getCityCode() {
    return cityCode;
  }

  public int getNumberSeats() {
    return numberSeats;
  }

  public int getPrice() {
    return price;
  }
}
