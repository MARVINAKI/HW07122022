package ShopQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShopQueue {
    private Queue<String> queue1 = new ArrayDeque<>(5);
    private Queue<String> queue2 = new ArrayDeque<>(5);
    private Queue<String> queue3 = new ArrayDeque<>();

    public enum Human {
        HUMAN1("name1"), HUMAN2("name2"), HUMAN3("name3"),
        HUMAN4("name4"), HUMAN5("name5"), HUMAN6("name6"),
        HUMAN7("name7"), HUMAN8("name8"), HUMAN9("name9"),
        HUMAN10("name10"), HUMAN11("name11"), HUMAN12("name12");

        private String name;

        Human(String name) {
            this.name = name.trim();
        }
    }

    public void addToQueue(Human... human) {
        for (int i = 0; i < human.length; i++) {
            if (queue1.size() < 5 && queue1.size() < queue2.size()) {
                queue1.offer(String.valueOf(human[i]));
            } else if (queue2.size() < 5) {
                queue2.offer(String.valueOf(human[i]));
            } else {
                queue3.offer(String.valueOf(human[i]));
            }
        }
    }

    @Override
    public String toString() {
        return "ShopQueue{" +
                "queue1=" + queue1 +
                ", queue2=" + queue2 +
                (queue3.size() != 0 ? ", queue3=" + queue3 : "") +
                '}';
    }
}
