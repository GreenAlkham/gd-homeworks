package files_task_2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {

        GameProgress gameProgress1 = new GameProgress(10, 5, 1, 5);
        GameProgress gameProgress2 = new GameProgress(8, 4, 2, 10);
        GameProgress gameProgress3 = new GameProgress(9, 6, 3, 15);

        String[] files = new String[]{"D:\\Нетология\\Games\\savegames\\save1.dat", "D:\\Нетология\\Games\\savegames\\save2.dat",
                "D:\\Нетология\\Games\\savegames\\save3.dat"};

        saveGame(files[0], gameProgress1);
        saveGame(files[1], gameProgress2);
        saveGame(files[2], gameProgress3);

        String zipPath = "D:\\Нетология\\Games\\savegames\\zip.zip";

        zipFiles(zipPath, files);
    }

    public static void saveGame(String filePath, GameProgress gameProgress) {

        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String zipPath, String[] files) {
        try {
            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (String s : files) {
                File fileToZip = new File(s);
                try {
                    FileInputStream fis = new FileInputStream(fileToZip);
                    zos.putNextEntry(new ZipEntry(fileToZip.getName()));
                    byte[] buffer = new byte[fis.available()];

                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                zos.closeEntry();
            }
            zos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for (String s : files) {
            new File(s).delete();
        }
    }
}
