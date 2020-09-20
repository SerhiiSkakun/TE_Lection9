//6. Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин строк.
package tasks;

import java.util.Comparator;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        new Task6().sortingForStringLength();
    }

    public void sortingForStringLength() {
        Task1 task1 = new Task1();
        List<String> list = task1.readFile();
        list.sort(Comparator.comparingInt(o -> (o).length()));
        task1.writeFile(list);
    }

//    public void sortingForStringLength() {
//        List<String> list = new Task1().readFile();
//        Collections.sort(list, (Comparator) (o1, o2) -> ((String)o1).length()-((String)o2).length());
//    }

//    public void sortingForStringLength() {
//        List<String> list = new Task1().readFile();
//        Collections.sort(list, new Comparator(){
//            @Override
//            public int compare(Object o1, Object o2) {
//                return ((String)o1).length()-((String)o2).length();
//            }
//        });
//    }
}
