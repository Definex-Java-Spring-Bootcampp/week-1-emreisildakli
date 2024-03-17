package OnlineShop.model;

import OnlineShop.enums.ProductCategory;
import OnlineShop.enums.StockType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Invoice> invoices = new ArrayList<>();

        Customer customer1 = new Customer("emre", LocalDate.of(1998, 11, 15));


        Product product1 = new Product("Laptop", ProductCategory.ELECTRONICS, StockType.IN_STOCK, 2100.00);
        Product product2 = new Product("T-shirt", ProductCategory.CLOTHING, StockType.IN_STOCK, 30.00);
        Product product3 = new Product("Keychain", ProductCategory.ACCESSORIES, StockType.IN_STOCK, 15.00);

        Order order1 = new Order();

        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product3);

        Invoice invoice1 = new Invoice(order1);

        customer1.addInvoice(invoice1);
        invoices.add(invoice1);
        customers.add(customer1);


    }

    //Sistemdeki bütün müşterisi sayısını bulan method
    public static int getCustomerNumber(ArrayList<Customer> customers) {
        return customers.size();
    }

    //İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan method
    public static int getProductNumberByName(ArrayList<Customer> customers, String name) {
        int total = 0;
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                for (Invoice invoice : customer.getInvoices()) {
                    total += invoice.getOrder().getProducts().size();
                }
            }
        }

        return total;
    }

    //İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayan method
    public static double getAmountByAgeAndName(ArrayList<Customer> customers, int maxAge, int minAge, String name) {
        double total = 0;

        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                long age = ChronoUnit.YEARS.between(customer.getBirthDate(), LocalDate.now());
                if (age > 25 && age < 30) {
                    for (Invoice invoice : customer.getInvoices()) {
                        total += invoice.getAmount();
                    }
                }
            }
        }
        return total;
    }

    //Sistemdeki 1500 TL üzerindeki faturaları listeleyen method.
    public static List<Invoice> getInvoicesOverLimit(List<Invoice> invoices, double limit) {
        return invoices.stream().filter(invoice -> invoice.getAmount() > limit).toList();
    }

}
