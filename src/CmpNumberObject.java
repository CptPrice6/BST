import java.util.Comparator;

public class CmpNumberObject implements Comparator {

    public int compare(Object o1, Object o2) {

        NumberObject num1 = (NumberObject) o1;
        NumberObject num2 = (NumberObject) o2;

        return num1.getNum().compareTo(num2.getNum());

    }

}
