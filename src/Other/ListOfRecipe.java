package Other;

import java.util.ArrayList;
import java.util.Objects;

public final class ListOfRecipe
        <R extends Recipe> {
    private final ArrayList<Recipe> listOfRecipe = new ArrayList<>();

    public void addToList(R... recipe) throws RecipeNameException {
        for (R rec : recipe) {
            for (Recipe recInList : listOfRecipe) {
                if (recInList.getRecipeName().equals(rec.getRecipeName())) {
                    throw new RecipeNameException();
                }

            }
            this.listOfRecipe.add(rec);
        }
    }

    @Override
    public String toString() {
        return "Рецепт" + listOfRecipe;
    }
}
