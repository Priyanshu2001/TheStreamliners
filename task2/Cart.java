package task2;

import java.util.ArrayList;



public class Cart {
    StringBuilder builder = new StringBuilder();
    ArrayList<GroceryCartItem> cartItems;
    float totalAmount;

    public Cart() {
        cartItems= new ArrayList<>();
        totalAmount=0;

    }
   public Cart add(GroceryCartItem item){
       builder.append("\n" + "\t" + item.name + " (" + "₹" + item.pricePerKg + " × " + item.quantity + "kg" + ") =" + " ₹" + item.price + "," + " \n");
        cartItems.add(item);
        totalAmount += item.quantity* item.price;
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "groceryCartItems=[" + builder.toString()+ "]"+
                "\n, totalAmount=" + totalAmount +
                '}';
    }
}
