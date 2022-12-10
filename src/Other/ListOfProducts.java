package Other;

import java.util.*;

public class ListOfProducts
        <P extends Product> {
    private final Set<Product> setOfProducts = new HashSet<>();
    private final ArrayList<Product> listOfProducts = new ArrayList<>();

    public ListOfProducts() {
        this.addToBasket();
    }

    @SafeVarargs
    public final void addToListOfProducts(P... product) throws DoubleProductException {
        for (int i = 0; i < product.length; i++) {
            for (Product products : listOfProducts) {
                if (product[i] == products) throw new DoubleProductException();
            }
            this.listOfProducts.add(product[i]);
        }
    }

    public final void removeFromList(P... product) {
        for (int i = 0; i < product.length; i++) {
            for (Product products : listOfProducts) {
                if (products != null && products == product[i]) {
                    listOfProducts.remove(products);
                }
            }
        }
    }

    @SafeVarargs
    public final void addToBasket(P... product) {
        this.setOfProducts.addAll(Arrays.asList(product));
    }

    public int calcSumm() {
        int sum = 0;
        for (Product products : setOfProducts) {
            sum += products.getPrice();
        }
        return sum;
    }

    public Set<Product> getSetOfProducts() {
        return setOfProducts;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    @Override
    public String toString() {
        return "ListOfProducts{" +
                "listOfProducts=" + setOfProducts +
                '}';
    }
}
