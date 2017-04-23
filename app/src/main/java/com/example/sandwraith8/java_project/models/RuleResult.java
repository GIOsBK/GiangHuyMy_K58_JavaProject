package com.example.sandwraith8.java_project.models;

import java.util.ArrayList;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

public class RuleResult {

    private String section;

    private String content;

    private int line;

    private ArrayList<String> words = new ArrayList<>();

    private String rule;



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

    public ArrayList<String> getWord() {
        return words;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void addWord(String word) {
        words.add(word);
    }
}

