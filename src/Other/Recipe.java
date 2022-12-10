package Other;

import java.util.Objects;

public class Recipe {
    private ListOfProducts basket;
    private Integer basketSumm;
    private String recipeName;

    public Recipe(ListOfProducts basket, Integer basketSumm, String recipeName) {
        this.basket = basket;
        this.basketSumm = basketSumm;
        if (recipeName == null || recipeName.trim().isEmpty()) {
            throw new NullPointerException();
        } else {
            this.recipeName = recipeName.trim();
        }
    }

    public final ListOfProducts getBasket() {
        return basket;
    }

    public final Integer getBasketSumm() {
        return basketSumm;
    }

    public final String getRecipeName() {
        return recipeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return basket.equals(recipe.basket) && basketSumm.equals(recipe.basketSumm) && recipeName.equals(recipe.recipeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basket, basketSumm, recipeName);
    }

    @Override
    public String toString() {
        return "Recept{" +
                "basket=" + basket +
                ", basketSumm=" + basketSumm +
                ", receptName='" + recipeName + '\'' +
                '}';
    }
}
