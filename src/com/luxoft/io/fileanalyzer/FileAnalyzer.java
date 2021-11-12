package com.luxoft.io.fileanalyzer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        searchAndCountTheWord("story.txt", "the");
        searchSentenceWithTheWord("story.txt", "the");
    }
    static String readContent(String path) throws IOException {
        File pathToFile = new File(path);
        InputStream inputStream = new FileInputStream(path);
        int fileLength = (int) pathToFile.length();
        byte[] contentArray = new byte[fileLength];
        inputStream.read(contentArray);
        return new String(contentArray);
    }
    public static String searchAndCountTheWord(String filePath, String wordSearch) throws IOException {
        int count = 0;
        String text = readContent(filePath);
        String[] words = text.toLowerCase().replaceAll("[-.?!)(,:]", "").split("\\s");
        for (String word : words) {
            if (word.equals(wordSearch)) {
                count++;
            }
        }
        String result = "The word " + "'" + wordSearch + "'"+ " meets " + count + " times in this file";
        System.out.println(result);
        return result;
    }
    public static List<String> searchSentenceWithTheWord(String filePath, String wordFind) throws IOException {
        String text = readContent(filePath);
        String[] sentences = text.toLowerCase().split("(?<=[.!?])\\s");
        List<String> result = new ArrayList<>();
        for (String sentence : sentences) {
            if (sentence.contains(wordFind)) {
                System.out.println(sentence);
                result.add(sentence);
            }
        }
        return result;
    }
}