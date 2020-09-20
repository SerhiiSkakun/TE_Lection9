//1. Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
package tasks;

import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        new Task1().run();
    }

    public void run() {
        List<String> list = readFile();
        Collections.reverse(list);
        writeFile(list);
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

    public void writeFile(List<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("text2.txt"))){
            writer.write(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                writer.newLine();
                writer.write(list.get(i));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
