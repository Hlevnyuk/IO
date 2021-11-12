package com.luxoft.io.filemanager;
import java.io.*;
import java.util.Objects;
public class FileManager {
    public static int countFiles(String path) {
        File file = new File(path);
        int count = 0;
        for(File o : Objects.requireNonNull(file.listFiles())){
            if(o.isDirectory()){
                count = count + countFiles(o.getPath());
            }
            count++;
        }
        return count;
    }
    public static int countDirs(String path) {
        File file = new File(path);
        int countDir = 0;
        for(File o : Objects.requireNonNull(file.listFiles())){
            if(o.isDirectory()){
                countDir = countDir + countDirs(o.getAbsolutePath());
            }
            countDir++;
        }
        return countDir;
    }
    public static void copy(String from, String to) throws IOException {
        File file = new File(from);
        File file1 = new File(to);
        for(File o : Objects.requireNonNull(file.listFiles())){
            if(o.isDirectory()){
                copy(o.getAbsolutePath(), file1.getAbsolutePath() + "\\" + o.getName());
            }
            File newFile = new File(file1.getAbsolutePath()  + "\\" + o.getName());
            newFile.createNewFile();
            copyFileContent(o, newFile);
        }
    }
    public static void copyFileContent(File from, File to) throws IOException {
        OutputStream output = new FileOutputStream(to);
        InputStream input  = new FileInputStream(from);
        int current;
        while((current = input.read()) != -1) {
            output.write(current);
        }
        output.close();
        input.close();
    }
    public static void move(String from, String to) throws IOException {
        copy(from, to);
        File src = new File(from);
        delete(src);
    }
    public static void delete(File element) {
        if (element.isDirectory()) {
            for (File sub : Objects.requireNonNull(element.listFiles())) {
                delete(sub);
            }
        }
        element.delete();
    }
}