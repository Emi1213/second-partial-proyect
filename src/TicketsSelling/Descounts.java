package TicketsSelling;

public class Descounts {
  public void getDescounts(boolean descount1) {

    if (descount1 == false) {
      totalprice = price;
    } else if (descount1 == true) {
      totalprice = price - (price * 0.10);

    }
  }
}
