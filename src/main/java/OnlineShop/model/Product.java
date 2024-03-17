package OnlineShop.model;

import OnlineShop.enums.ProductCategory;
import OnlineShop.enums.StockType;

import java.util.Objects;

public class Product {
    private String name;
    private ProductCategory category;
    private StockType stockInfo;
    private double price;

    public Product(String name, ProductCategory category, StockType type, double price) {
        this.name = name;
        this.category = category;
        this.stockInfo = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(name, product.name) && category == product.category && stockInfo == product.stockInfo;
    }


}
