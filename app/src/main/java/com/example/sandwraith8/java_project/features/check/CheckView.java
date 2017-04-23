package com.example.sandwraith8.java_project.features.check;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

import java.util.ArrayList;

import com.example.sandwraith8.java_project.models.RuleResult;
import com.example.sandwraith8.java_project.models.SearchResult;


public interface CheckView {
    void getAllWordInvalidDone(RuleResult results);

    void getAllWordInvalidSuccess(ArrayList<SearchResult> results);

    void updateWordInvalidDone(SearchResult result);
}

