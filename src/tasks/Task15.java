//15. Задан файл с текстом на английском языке. Выделить все различные слова. Слова,
//отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashMap
package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task15 {
    public static void main(String[] args) {
        Task15 task15 = new Task15();
        List<String> list = task15.readFile();
        String bigString = task15.concatLines(0,list.size(),list);
        Map<String, Integer> wordMapWithCounts = task15.countWordsByLength(bigString);
        for (Map.Entry entry : wordMapWithCounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public List<String> readFile() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
            while (reader.ready()){
                list.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String concatLines(int start, int count, List<String> list){
        List sublist = list.subList(start, start + count);
        return String.join("\n", sublist);
    }

    public Map<String,Integer> countWordsByLength(String bigLine) {
        List<String> wordList = Arrays.asList(bigLine.split("[^'&&[\\W]]+"));
        Map<String,Integer> wordMapWithCounts = new TreeMap<>();
        for (String word : wordList) {
            Integer count = wordMapWithCounts.get(word.toLowerCase());
            if(count == null) count = 1;
            else count++;
            wordMapWithCounts.put(word.toLowerCase(),count);
        }
        return wordMapWithCounts;
    }
}