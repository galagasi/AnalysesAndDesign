import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Account {
    private String id;
    private String billing_address;
    private boolean is_closed;
    private Date open;
    private Date closed;
    private float balance;

    // Associations
    private HashMap<String, Payment> payments;
    private ArrayList<Order> orders;
    private ShoppingCart shoppingCart;
    private Customer customer;

    public Account(String id, String billing_address, WebUser webUser, Customer customer) {
        this.id = id;
        this.open = new Date();
        this.closed = null;
        this.is_closed = false;
        this.billing_address = billing_address;
        this.shoppingCart = new ShoppingCart(webUser.getLogin_id()+"'s ShoppingCart", webUser,this);
        this.customer = customer;
        this.balance = 0;
        orders = new ArrayList<>();
        payments = new HashMap<>();
    }

    /**
     * adds a new order to orders list
     * @param order
     */
    public void addOrder(Order order){
        if(!orders.contains(order)){
            orders.add(order);
        }
    }

    /**
     * adds a new payment to payments list
     * @param payment
     */
    public void addPayment (Payment payment){
        if (!payments.containsKey(payment.getId())) {
            payments.put(payment.getId(), payment);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public HashMap<String, Payment> getPayments() {
        return payments;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void removeAssociated(){
        this.shoppingCart = null;
        for(Order o : this.orders){
            o.removeAssociated();
        }
        this.orders = null;
        for(Payment p: this.payments.values()){
            p.removeAssociated();
        }
        this.payments = null;
        this.customer = null;
    }

    @Override
    public String toString() {
        return "Account: \n\tID: " + id + ", Name: " + id;
    }

    public void showAssociated() {
        if (this.customer != null) System.out.println(this.customer);
        if (this.shoppingCart != null) System.out.println(this.shoppingCart);
        if (this.payments != null) {
            for (Payment p : this.payments.values()) {
                System.out.println(p);
            }
        }
        if (this.orders != null){
            for (Order o: this.orders){
                System.out.println(o);
            }
        }

    }

    public String showAllDetails(){
        return this.toString()+", Address: " + this.billing_address + ", Date opened: " + this.open +
                "is closed: " + this.is_closed + ", Date closed: " + this.closed + ", Balance: "+this.balance;
    }
}
