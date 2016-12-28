import java.util.*;

/**
 * Created by Luke Chang on 28-Dec-16.
 */
public class QueueExample {

    public void queueEx1() {
        // 2 type of Queue
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new PriorityQueue<>();

        List<String> l = Arrays.asList("a1", "b2", "c1", "a2", "b1");
        for (String o : l) {
            q1.add(o);
            q2.add(o);
        }

        System.out.println(q1); // [a1, b2, c1, a2, b1]
        System.out.println(q2); // [a1, a2, c1, b2, b1]

        Queue<Integer> q3 = new LinkedList<>();

        // Min-Heap by default
        Queue<Integer> q4 = new PriorityQueue<>();

        List<Integer> l2 = Arrays.asList(7, 9, 1, 3, 2);
        for (int o : l2) {
            q3.add(o);
            q4.add(o);
        }

        // FIFO first in first out
        System.out.println(q3); // [7, 9, 1, 3, 2]
        System.out.println(q3.peek());
        System.out.println(q3.remove());
        System.out.println(q4); // [1, 2, 7, 9, 3]
        System.out.println(q4.peek());
        System.out.println(q4.remove());
        System.out.println(q4);

        // Max-Heap
        // Using lambda to override comparator
        Queue<Integer> q5 = new PriorityQueue<>((x1, x2) -> {
            if (x1 < x2) return 1;
            else if (x1 > x2) return -1;
            else return 0;
        });
        for (int o : l2) {
            q5.add(o);
        }
        System.out.println(q5); // [9, 7, 1, 3, 2]
        System.out.println(q5.peek());
        System.out.println(q5.remove());
        System.out.println(q5);

        Queue<Integer> q6 = new PriorityQueue<>(Collections.reverseOrder());
        for (int o : l2) {
            q6.add(o);
        }
        System.out.println(q6); // [9, 7, 1, 3, 2]
        System.out.println(q6.peek());
        System.out.println(q6.remove());
        System.out.println(q6);
    }

    public static void main(String[] args) {
//        new QueueExample().queueEx1();
//        new DequeExample().run();
        new MapExample().run();

    }
}
