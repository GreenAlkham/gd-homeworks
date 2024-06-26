package files_task_1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        File games = new File("D:\\Нетология\\Games");

        // Cоздание директорий src, res, savegames, temp в папке Games

        File src = new File(games, "src");
        if (src.mkdir())
            sb.append("Создан каталог: " + src).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + src).append(System.lineSeparator());

        File res = new File(games, "res");
        if (res.mkdir())
            sb.append("Создан каталог: " + res).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + res).append(System.lineSeparator());

        File savegames = new File(games, "savegames");
        if (savegames.mkdir())
            sb.append("Создан каталог: " + savegames).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + savegames).append(System.lineSeparator());

        File temp = new File(games, "temp");
        if (temp.mkdir())
            sb.append("Создан каталог: " + temp).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + temp).append(System.lineSeparator());

        // Создание директорий main, test в каталоге src

        File main = new File(src, "main");
        if (main.mkdir())
            sb.append("Создан каталог: " + main).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + main).append(System.lineSeparator());

        File test = new File(src, "test");
        if (test.mkdir())
            sb.append("Создан каталог: " + test).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + test).append(System.lineSeparator());

        // Создание файлов Main.java, Utils.java в подкаталоге main

        File mainFile = new File(main, "Main.java");
        try {
            if (mainFile.createNewFile())
                sb.append("Создан файл: " + mainFile).append(System.lineSeparator());
        } catch (IOException ex) {
            sb.append("Ошибка создания файла " + mainFile + " : " + ex.getMessage())
                    .append(System.lineSeparator());
        }

        File utilsFile = new File(main, "Utils.java");
        try {
            if (utilsFile.createNewFile())
                sb.append("Создан файл: " + utilsFile).append(System.lineSeparator());
        } catch (IOException ex) {
            sb.append("Ошибка создания файла " + utilsFile + " : " + ex.getMessage())
                    .append(System.lineSeparator());
        }

        // Создание директорий drawables, vectors, icons в каталог res

        File drawables = new File(res, "drawables");
        if (drawables.mkdir())
            sb.append("Создан каталог: " + drawables).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + drawables).append(System.lineSeparator());

        File vectors = new File(res, "vectors");
        if (vectors.mkdir())
            sb.append("Создан каталог: " + vectors).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + vectors).append(System.lineSeparator());

        File icons = new File(res, "icons");
        if (icons.mkdir())
            sb.append("Создан каталог: " + icons).append(System.lineSeparator());
        else sb.append("Ошибка создания каталога: " + icons).append(System.lineSeparator());

        // Создание файла temp.txt в директории temp

        File tempFile = new File(temp, "temp.txt");
        try {
            if (tempFile.createNewFile())
                sb.append("Создан файл: " + tempFile).append(System.lineSeparator());
        } catch (IOException ex) {
            sb.append("Ошибка создания файла " + tempFile + " : " + ex.getMessage())
                    .append(System.lineSeparator());
        }

        // Запись лога в файл temp.txt

        try (FileWriter writer = new FileWriter(tempFile, true)) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
