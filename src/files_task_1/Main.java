package files_task_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String GAMES = "D:/Нетология/Games";

    public static StringBuilder sb = new StringBuilder();

    public static List<File> createDir() {

        //Создание списка для хранения директорий и путей к ним
        List<String> dir = new ArrayList<>();

        // Добавление в список директорий src, res, savegames, temp в папке Games
        dir.add(GAMES + "/src");
        dir.add(GAMES + "/res");
        dir.add(GAMES + "/savegames");
        dir.add(GAMES + "/temp");

        // Добавление в список директорий main, test в каталоге src
        dir.add(GAMES + "/src/main");
        dir.add(GAMES + "/src/test");

        // Добавление в список директорий drawables, vectors, icons в каталог res
        dir.add(GAMES + "/res/drawables");
        dir.add(GAMES + "/res/vectors");
        dir.add(GAMES + "/res/icons");

        //Преобразование списка String в File
        List<File> directories = new ArrayList<>();
        for (int i = 0; i < dir.size(); i++) {
            directories.add(new File(dir.get(i)));
        }

        //Создание директорий:
        for (File directory : directories) {
            if (directory.mkdir())
                sb.append("Создан каталог: " + directory).append(System.lineSeparator());
            else sb.append("Ошибка создания каталога: " + directory).append(System.lineSeparator());
        }
        return directories;
    }

    public static List<File> createFiles() {

        //Создание списка для хранения директорий и путей к ним
        List<String> filesList = new ArrayList<>();

        // Добавление в список файлов Main.java, Utils.java в подкаталоге main
        filesList.add(GAMES + "/src/main/Main.java");
        filesList.add(GAMES + "/src/main/Utils.java");

        // Добавление в список файла temp.txt в директории temp
        filesList.add(GAMES + "/temp/temp.txt");

        //Преобразование списка String в File
        List<File> files = new ArrayList<>();
        for (int i = 0; i < filesList.size(); i++) {
            files.add(new File(filesList.get(i)));
        }

        //Создание файлов:
        for (File file : files) {
            try {
                if (file.createNewFile())
                    sb.append("Создан файл: " + file).append(System.lineSeparator());
            } catch (IOException ex) {
                sb.append("Ошибка создания файла " + file + " : " + ex.getMessage())
                        .append(System.lineSeparator());
            }
        }
        return files;
    }

    public static void recordLog() {
        String tempFile = GAMES + "\\temp\\temp.txt";

        // Запись лога в файл temp.txt
        try (FileWriter writer = new FileWriter(tempFile, true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        createDir();
        createFiles();
        recordLog();
    }
}