//10. С использованием множества выполнить попарное суммирование произвольного конечного
//ряда чисел по следующим правилам: на первом этапе суммируются попарно рядом стоящие числа,
//на втором этапе суммируются результаты первого этапа и т. д. до тех пор, пока не останется одно
//число.
package tasks;

import java.util.*;

public class Task10 {
    public static void main(String[] args) {
//        List<Integer> set = new new HashSet<>(Task13().readListFromConsole());
        Set<Integer> set = new HashSet<>(Arrays.asList(-1,3,5,0,-6,-5,8,9));
        int result = new Task10().uniqueIntLast(set);
        System.out.println(result);
    }

    public int uniqueIntLast(Set<Integer> set) {
        Deque<Integer> deque = new ArrayDeque<>(set);
        while (deque.size()>1)
            deque.addLast(deque.pollFirst() + deque.pollFirst());
        return deque.getFirst();
    }
}
