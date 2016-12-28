import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Luke Chang on 28-Dec-16.
 */
public class DequeExample {

    public void run() {
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new LinkedList<>();

        int[] nums = {7, 9, 1, 3, 2};
        for(int i : nums) {
            d1.add(i);
            d2.add(i);
        }
        System.out.println(d1);
        d1.remove();
        System.out.println(d1);

        System.out.println(d2);
        d2.remove();
        System.out.println(d2);

//        Collections.sort(d2); // only works on LinkedList
    }
}
