package task1;

public class Main {
    public static void main(String args[]){
        Product product1= new Product("Apple",100);
        Product product2= new Product("Apple",100);
        Product product3= new Product("Orange",100);

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product1.equals(product2));

        SpecialProduct specialProduct=SpecialProduct.applyOffOnProduct(product3,20);
        System.out.println(specialProduct);
    }
}
