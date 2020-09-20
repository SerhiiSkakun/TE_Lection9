//2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
package tasks;

import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        new Task2().run();
    }

    private void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        try {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(processNumber(n));
    }

    public int processNumber(int n){
        Deque<Integer> numbers = new ArrayDeque<>();
        do{
            numbers.add(n%10);
            n = n/10;
        } while (n > 0);
        int number = 0;
        while (!numbers.isEmpty()) {
            number *=10;
            number += numbers.pollFirst();
        }
        return number;
    }
}
