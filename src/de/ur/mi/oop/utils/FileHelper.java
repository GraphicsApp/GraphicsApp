package de.ur.mi.oop.utils;

import java.io.File;

public class FileHelper {

    public static File loadFile(String filePath) {
        File file = new File(filePath);
        return file;
    }
}
