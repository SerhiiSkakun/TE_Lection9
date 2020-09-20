package tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task4_cmd {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Task4_cmd task4 = new Task4_cmd();
        File file = task4.readFile();
        task4.makingDirectoriesList(file);
        for (String fileName : list) {
            System.out.println(fileName);
        }
    }

    public void makingDirectoriesList(File file) {
// /s означает поиск подкаталогов
// /ad означает только каталоги возврата
// /b означает возвращение полного пути из корня
        try {
            Runtime r = Runtime.getRuntime();
            String command = "cmd.exe /k dir /s/b/ad " + file.getAbsolutePath();
            Process p = r.exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            for (; ; ) {
                String d = reader.readLine();
                if (d == null) break;
                System.out.println(d);
                list.add(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
