import java.util.ArrayList;

public class LineItem {
    private int quantity;
    private int price;
    private boolean isOrdered; // line item goes only to one order
    private static Integer autoID=0;
    private String ID;

    // Associations
    private Order order;
    private ShoppingCart shoppingCart;
    private Product product;



    public LineItem(String id, Product p, int quantity, int price, Order order, ShoppingCart shoppingCart) {
        this.autoID += 1;
        this.ID = id +" "+this.autoID;
        this.product = p;
        this.order = order;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
        this.price = price;
        this.isOrdered = false;
        this.product.addLineItem(this); // add the line item to product object.
        this.order.addLineItem(this);
        this.shoppingCart.addLineItem(this);

    }

    public int getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    public String showAllDetails() {
        return this.toString() + ", quantity: " + this.quantity + ", price: "+ this.price;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString(){
        return "LineItem:\n\tID: " + this.ID+ ", Product's name: "+this.product.getName();
    }

    public void removeAssociated() {
        this.shoppingCart = null;
        this.order = null;
        this.product.removeLineItem(this);
        this.product = null;
    }

    public void showAssociated() {
        if (this.shoppingCart != null) System.out.println(this.shoppingCart);
        if (this.product != null) System.out.println(this.product);
        if (this.order != null) System.out.println(this.order);
    }
}
