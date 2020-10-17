package task2;

import java.awt.geom.Arc2D;

public class GroceryCartItem extends GroceryItem{
 float quantity, price;
    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);
    }

    @Override
    public String toString() {
        return (String.format("%s (Rs. %d x %f kg) = Rs. %f",name,pricePerKg,quantity,price));
    }
    public static float extractQuantity(String quantityStr){
         float quant;
      String quantitystr = quantityStr.replace("kg ",".")
                                    .replace("kg",".")
                                    .replace("g","");

      if(!quantitystr.contains("."))
          quantitystr= "." +quantitystr;

        if (quantityStr.length()<=3)
        quant=Float.parseFloat(quantitystr)/1000;
        else
        quant=Float.parseFloat(quantitystr);

        return quant;

    }
    public static GroceryCartItem createNew(GroceryItem item, String quantityStr){
        GroceryCartItem cartItem =new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity= extractQuantity(quantityStr);
        cartItem.price=item.pricePerKg* cartItem.quantity;
        return cartItem;

    }
}
