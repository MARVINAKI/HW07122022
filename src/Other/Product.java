package Other;

import java.util.Objects;

public class Product {
    private String title;
    private Integer price;
    private Integer amount;

    public Product(String title, Integer price, Integer amount) {
        if (title == null || title.trim().isEmpty()) {
            throw new NullPointerException();
        } else {
            this.title = title.trim();
        }
        this.price = Math.abs(price);
        this.amount = Math.abs(amount);
    }

    public final String getTitle() {
        return title;
    }

    public final int getPrice() {
        return price;
    }

    public final int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product1 = (Product) o;
        return title.equals(product1.title) && price.equals(product1.price) && amount.equals(product1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", amount=" + amount + "\n" +
                '}';
    }
}
