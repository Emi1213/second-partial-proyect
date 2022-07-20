package TicketsSelling;

import java.util.ArrayList;

public class Descounts {
  ArrayList<Destino> arrayDescounts;
  String[] citycodes = { "17", "13", "09", "07" };
  double prices;
  double descountscity = 0;
  double pricetotality = 0;
  double totalprice;
  double subtotalprice;
  double finalprice;
  double seconddescount;

  

  public double getFirstDescount() {
    for (int i = 0; i < arrayDescounts.size(); i++) {
      if (arrayDescounts.get(i).getCityCode() == "17") {
        prices = arrayDescounts.get(i).getPrice()-(arrayDescounts.get(i).getPrice()*0.1);
        descountscity = (arrayDescounts.get(i).getPrice()*0.1);


      } else if (arrayDescounts.get(i).getCityCode() == "13") {
        prices = arrayDescounts.get(i).getPrice()-(arrayDescounts.get(i).getPrice()*0.1);

      } else if (arrayDescounts.get(i).getCityCode() == "07") {
        prices = arrayDescounts.get(i).getPrice()-(arrayDescounts.get(i).getPrice()*0.1);

      }else if (arrayDescounts.get(i).getCityCode() == "07") {
        prices = arrayDescounts.get(i).getPrice()-(arrayDescounts.get(i).getPrice()*0.1);

      }

      pricetotality += prices;
      descountscity += descountscity;
      return descountscity;

    }

  public double getSecondDescount(int destinationsQuantity) {
    
    if (destinationsQuantity >= 3) {
      if(pricetotality >= 15){
        seconddescount = (pricetotality*0.03);
      } else if (pricetotality >= 20) {
      seconddescount = (pricetotality*0.10);
   

        seconddescount = (pricetotality*0.6);
      } else if (pricetotality >= 20) {
      seconddescount = (pricetotality*0.12);
      }
    }
      return seconddescount;

  public double getDescounts(boolean descount1) {
    if (descount1 == true) {
      finalprice = subtotalprice - (subtotalprice * 0.02);
    } else {
      finalprice = subtotalprice;
    }
    return finalprice;
  }
}
