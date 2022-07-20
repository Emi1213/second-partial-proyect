package TicketsSelling;

import java.util.ArrayList;

public class Descounts {
  ArrayList<Destino> arrayDescounts = new ArrayList<>();
  String[] citycodes = { "17", "13", "09", "07" };
  double prices;
  double descountscity = 0;
  double pricetotality = 0;
  double totalprice;
  double subtotalprice;
  double finalprice;
  double seconddescount;
  double descounttotal;
  double impuestoPrice;
  double subtotalwithD;

  public double getSubtotaltDescount() {

    for (int i = 0; i < arrayDescounts.size(); i++) {
      if (arrayDescounts.get(i).getCityCode() == "17") {
        prices = arrayDescounts.get(i).getPrice() - (arrayDescounts.get(i).getPrice() * 0.1);
        descountscity = (arrayDescounts.get(i).getPrice() * 0.1);

      } else if (arrayDescounts.get(i).getCityCode() == "13") {
        prices = arrayDescounts.get(i).getPrice() - (arrayDescounts.get(i).getPrice() * 0.1);

      } else if (arrayDescounts.get(i).getCityCode() == "07") {
        prices = arrayDescounts.get(i).getPrice() - (arrayDescounts.get(i).getPrice() * 0.1);

      } else if (arrayDescounts.get(i).getCityCode() == "07") {
        prices = arrayDescounts.get(i).getPrice() - (arrayDescounts.get(i).getPrice() * 0.1);

      }

      subtotalprice += prices;
      descountscity += descountscity;
    }

    return subtotalprice;
  }

  public double getFisrtDescount() {
    return descountscity;
  }

  public double getSecondDescount(int destinationsQuantity) {
    if (destinationsQuantity >= 3) {
      if (subtotalprice >= 10) {
        seconddescount = (subtotalprice * 0.01);
      } else if (subtotalprice >= 15) {
        seconddescount = (subtotalprice * 0.02);
      } else if (subtotalprice >= 20) {
        seconddescount = (subtotalprice * 0.03);
      }
    }
    if (destinationsQuantity >= 5) {
      if (subtotalprice >= 30) {
        seconddescount = (subtotalprice * 0.04);
      } else if (subtotalprice >= 20) {
        seconddescount = (subtotalprice * 0.05);

      } else if (subtotalprice >= 20) {
        seconddescount = (subtotalprice * 0.06);
      }
    }
    return seconddescount;
  }

  public double getDescountTotal() {
    descounttotal = descountscity + seconddescount;
    return descounttotal;
  }

  public double getIVAPrice() {
    subtotalwithD = subtotalprice - seconddescount;
    impuestoPrice = (subtotalprice * 0.12);
    return impuestoPrice;
  }

  public double getTotalPrice() {
    totalprice = subtotalprice + impuestoPrice;
    return totalprice;
  }

  public double getDescounts(boolean descount1) {
    if (descount1 == true) {
      finalprice = totalprice - (subtotalprice * 0.02);
    } else {
      finalprice = totalprice;
    }
    return finalprice;
  }
}
