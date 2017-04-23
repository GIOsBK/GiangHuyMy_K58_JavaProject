package com.example.sandwraith8.java_project.models;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

public class SearchResult {
    private String section;

    private String content;

    private String word;

    private int line;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
