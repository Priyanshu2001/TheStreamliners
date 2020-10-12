package task2;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        GroceryItem sugar = new GroceryItem("Sugar", 40);
        GroceryItem wheat = new GroceryItem("Wheat", 35);
        GroceryItem rice = new GroceryItem("Rice", 25);
        GroceryItem jaggery = new GroceryItem("Jaggery", 60);
        Cart cart = new Cart();
        cart.add(GroceryCartItem.createNew(sugar,"3kg 0g"))
                .add(GroceryCartItem.createNew(sugar,"3kg 500g"))
                .add(GroceryCartItem.createNew(sugar,"2kg 700g"))
                .add(GroceryCartItem.createNew(sugar,"0kg 75g"));
        System.out.println(cart);
    }

}
