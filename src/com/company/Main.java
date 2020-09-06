package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sbAll = new StringBuilder();

        String[] dir = new String[]{"src", "res", "savegames", "temp"};
        String installFolder = "D://Games/";
        sbAll.append(makeFolder(dir, installFolder));

        dir = new String[]{"drawables", "vectors", "icons"};
        installFolder = "D://Games/res/";
        sbAll.append(makeFolder(dir, installFolder));

        dir = new String[]{"main", "test"};
        installFolder = "D://Games/src/";
        sbAll.append(makeFolder(dir, installFolder));

        File fileMain = new File("D:/Games/src/main/Main.java");
        File fileUtils = new File("D:/Games/src/main/Utils.java");
        File fileTemp = new File("D:/Games/temp/temp.txt");

        try {
            if (fileMain.createNewFile()) sbAll.append("Файл \"D:/Games/src/main/Main.java\" создан ");
        } catch (IOException ex) {
            sbAll.append("Файл \"D:/Games/src/main/Main.java\" не создан ");
        }

        try {
            if (fileUtils.createNewFile()) sbAll.append("Файл \"D:/Games/src/main/Utils.java\" создан ");
        } catch (IOException ex) {
            sbAll.append("Файл \"D:/Games/src/main/Utils.java\" не создан ");
        }

        try {
            if (fileTemp.createNewFile()) sbAll.append("Файл \"D:/Games/src/main/Main.java\" создан ");
        } catch (IOException ex) {
            System.out.println("Файл \"D:/Games/temp/temp.txt\" не создан ");
        }

        try (FileWriter writer = new FileWriter("D:/Games/temp/temp.txt ", false)) {
            writer.write(String.valueOf(sbAll));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static StringBuilder makeFolder(String[] dir, String installFolder) {
        StringBuilder sb = new StringBuilder();
        for (String s : dir) {
            File dir1 = new File(installFolder + s);
            if (dir1.mkdir()) {
                sb.append("Каталог ").append(installFolder).append(s).append(" создан ");
            } else {
                sb.append("Ошибка при создании каталога ").append(installFolder).append(s);
            }
        }
        return sb;
    }
}

