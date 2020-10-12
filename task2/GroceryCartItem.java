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
      String[] str = quantityStr.split(" ",quantityStr.length());
      String replaceStr0= str[0].replace("kg","");
      String replaceStr1= str[1].replace("g","");
      int part1 = Integer.parseInt(replaceStr0);
      int part2 = Integer.parseInt(replaceStr1);
        return part1+(float)part2/1000;

    }
    public static GroceryCartItem createNew(GroceryItem item, String quantityStr){
        GroceryCartItem cartItem =new GroceryCartItem(item.name, item.pricePerKg);
        cartItem.quantity= extractQuantity(quantityStr);
        cartItem.price=item.pricePerKg* cartItem.quantity;
        return cartItem;

    }
}
