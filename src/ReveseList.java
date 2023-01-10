import java.util.*;

public class ReveseList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        List<String> b = Arrays.asList("b","c");
        Set<String> set = new HashSet<>();
        set.addAll(a);
        set.addAll(b);
        System.out.println(set);
        a.addAll(set);
        System.out.println(a);
    }
}
