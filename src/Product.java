import java.util.ArrayList;

public class Product {
    private String id;
    private String name;

    //added attributes
    private int price;

    // Associations
    private Supplier supplier;
    private ArrayList<LineItem> lineItems;
    private PremiumAccount premiumAccount;

    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.price = 10;
        this.supplier = supplier;
        this.supplier.addProduct(this);
        this.lineItems = new ArrayList<>();
        this.premiumAccount = null;

    }
  
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PremiumAccount getPremiumAccount() {
        return premiumAccount;
    }

    //connects prem
    public void setPremiumAccount(PremiumAccount premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    //need to connect also from lineItem, !!
    public void addLineItem(LineItem lineItem){
        if (!lineItems.contains(lineItem))
        {
            lineItems.add(lineItem);
        }

    }

    @Override
    public String toString() {
        return "Product: \nProduct id: " + id + ", name: " + name;
    }

    public String displayProduct(){
        String details = this.toString() + "\nSupplier:\n";
        details+=this.supplier.getName() +"\n";
        if(this.premiumAccount != null){
            details += this.premiumAccount.getId() + "\n";
        }
        for(LineItem li: this.getLineItems()){
            details+= li.getID() + ", ";
        }
        if(this.getLineItems().size() > 1) return details.substring(0, details.length()-2);
        return details;
    }
}
