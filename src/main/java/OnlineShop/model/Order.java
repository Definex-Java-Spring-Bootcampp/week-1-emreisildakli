package OnlineShop.model;

import java.util.ArrayList;

public class Order {
    private Invoice invoice;

    private ArrayList<Product> products;
    private double totalPrice;

    public Order() {
        this.products = new ArrayList<>();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void addProduct(Product product) {
        if (!this.products.contains(product)) {
            this.products.add(product);
            this.totalPrice += product.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
