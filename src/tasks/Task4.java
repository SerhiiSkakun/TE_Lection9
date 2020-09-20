//4. Создать список из элементов каталога и его подкаталогов.
package tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4{
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Task4 task4 = new Task4();
        File file = task4.readFile();
        task4.makingDirectoriesList(file);
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }

    private void makingDirectoriesList(File file) {
        list.add(file.getAbsolutePath());
        List<File> fileList = Arrays.asList(file.listFiles());
        for (File currentFile : fileList) {
            if(currentFile.isDirectory()) makingDirectoriesList(currentFile);
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
}