package TicketsSelling;

public class NumberSeats {
  String cityName;
  String cityCode;
  int numberSeats;
  int normalPrice;
  int groupPrice;
  int price;

  public int Destin(String line, int numberSeatsToSet) {
    String[] arrayDestiny = line.split(";");

    this.cityName = arrayDestiny[0];
    this.cityCode = arrayDestiny[1];
    this.numberSeats = Integer.parseInt(arrayDestiny[2]);
    this.normalPrice = Integer.parseInt(arrayDestiny[3]);
    this.groupPrice = Integer.parseInt(arrayDestiny[4]);

    if (numberSeatsToSet <= 4) {
      price = groupPrice * numberSeatsToSet;
    } else {
      price = normalPrice * numberSeatsToSet;
    }

    return price;
  }

}
