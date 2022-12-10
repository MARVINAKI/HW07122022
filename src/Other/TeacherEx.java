package Other;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TeacherEx {
    private ArrayList<Integer> num;
    private final Set<ArrayList> ex = new HashSet<>() {
    };

    public void printEx() {
        while (ex.size() != 15) {
            ex.add(fillNum());
            for (ArrayList i : ex) {
                if (num.get(0) < 2 || num.get(1) < 2) {
                    ex.remove(num);
                    break;
                } else if (num.hashCode() == i.hashCode()) {
                    continue;
                }
                if (i.get(0) == num.get(1) && i.get(1) == num.get(0)) {
                    ex.remove(num);
                    break;
                }
            }
        }
        for (ArrayList<Integer> i : ex) {
            System.out.println(i.get(0) + "*" + i.get(1) + "=");
        }
    }

    public ArrayList<Integer> fillNum() {
        num = new ArrayList<>();
        num.add((int) (Math.random() * 10));
        num.add((int) (Math.random() * 10));
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEx teacherEx = (TeacherEx) o;
        return num.equals(teacherEx.num) && ex.equals(teacherEx.ex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, ex);
    }

}
