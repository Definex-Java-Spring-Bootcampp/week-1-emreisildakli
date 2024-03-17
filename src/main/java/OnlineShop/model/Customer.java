package OnlineShop.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private LocalDate birthDate;

    private ArrayList<Invoice> invoices;

    public Customer(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.invoices = new ArrayList<>();
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
