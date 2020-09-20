//4. Создать список из элементов каталога и его подкаталогов.
package tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task4_multi{
    static List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Task4_multi task4 = new Task4_multi();
        File file = new File("c:\\TC\\");   //Только для тестирования
//        File file = task4.readFile();             //Рабочий вариант
        task4.new FileStructure(file).makingDirectoriesList();

//        try {                                     //Без sleep не успевает отработать
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }

    private File readFile() {
        String fileName = "";
        File file = new File(fileName);
        do {
            if(!fileName.equals("")){
                if(!file.exists()) System.out.println("Папки с таким именем не существует.");
                else System.out.println("Это файл, а не папка.");
                System.out.println("Повторите пожалуйста ввод.");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                fileName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file = new File(fileName);
        }while (!file.exists() || !file.isDirectory() );
        //System.out.println("Имя папки введено правильно.");
        return file;
    }

    class FileStructure implements Runnable{
        File file;

        FileStructure(File file){
            this.file = file;
        }

        @Override
        public void run() {
            makingDirectoriesList();
        }

        private void makingDirectoriesList() {
            list.add(file.getAbsolutePath());
            List<File> fileList = Arrays.asList(file.listFiles());
            ListIterator<File> iterator = fileList.listIterator();
            while (iterator.hasNext()){
                File currentFile = iterator.next();
                if (currentFile.isDirectory()) {
                    new Thread(new FileStructure(currentFile)).start();
                }
            }
        }
    }
}