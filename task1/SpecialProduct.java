package task1;

public class SpecialProduct extends Product{
   int regularPrice,percentageOff;

    public SpecialProduct(String name, int price) {
        super(name, price);
    }


    @Override
    public String toString() {
        return "SpecialProduct{" +
                "regularPrice=" + regularPrice +
                ", percentageOff=" + percentageOff +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static SpecialProduct applyOffOnProduct(Product product, int percentageOff) {
        int discountedPrice= product.price - ((product.price*percentageOff)/100);
        SpecialProduct specialProduct= new SpecialProduct(product.name, discountedPrice);
        specialProduct.regularPrice= product.price;
        specialProduct.percentageOff=percentageOff;
        return specialProduct;
    }
}
