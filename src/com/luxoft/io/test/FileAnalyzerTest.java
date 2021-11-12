package com.luxoft.io.test;
import com.luxoft.io.fileanalyzer.FileAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class FileAnalyzerTest{
    @Test
    public void testSearchByWord() throws IOException {
        String expected = "The word " + "'" + "the" + "'" + " meets " + 8 + " times in this file";
        assertEquals(expected, FileAnalyzer.searchAndCountTheWord("story.txt", "the"));
    }
    @Test
    public void testSearchAllSentencesWithThisWord() throws IOException {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("\nabout one billion people speak or understand english!");
        assertEquals(expected, FileAnalyzer.searchSentenceWithTheWord("story.txt", "billion"));
    }
}
