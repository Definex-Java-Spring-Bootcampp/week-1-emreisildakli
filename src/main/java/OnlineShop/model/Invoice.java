package OnlineShop.model;

public class Invoice {
    private Order order;
    private double amount;

    public Invoice(Order order) {
        this.order = order;
        this.amount = order.getTotalPrice();
    }

    public double getAmount() {
        return amount;
    }

    public Order getOrder() {
        return order;
    }


}
