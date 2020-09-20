//13. Не используя вспомогательных объектов, переставить отрицательные элементы данного
//списка в конец, а положительные — в начало списка.
package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task13 {
    public static void main(String[] args) {
        Task13 task13 = new Task13();
        List<Integer> list = task13.readListFromConsole();
//        List<Integer> list = Arrays.asList(-1,3,5,0,-6,-5,8,9);
        task13.elementsExchange(list);
    }

    public List<Integer> readListFromConsole() {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line = reader.readLine();
            while (!"exit".equals(line)){
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void elementsExchange(List<Integer>list) {
        int i = 0;
        int j = list.size()-1;
        for (; i < j; i++) {
            int elementMinus = list.get(i);
            if (elementMinus < 0){
                for (; j > i; j--) {
                    int elementPlus = list.get(j);
                    if (elementPlus > 0) {
                        list.set(i,list.set(j,list.get(i)));
                        j--;
                        break;
                    }
                }
            }
        }
    }
}