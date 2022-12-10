package Other;

import java.util.ArrayList;
import java.util.Random;

public class Numbers {
    private final ArrayList<Integer> numbers = new ArrayList<>(20);

    public final void fillingAndPrint() {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.add((int) (Math.random() * 1000));
            if (numbers.get(i) % 2 == 0) {
                System.out.println(numbers.get(i));
            }
        }
    }
}
