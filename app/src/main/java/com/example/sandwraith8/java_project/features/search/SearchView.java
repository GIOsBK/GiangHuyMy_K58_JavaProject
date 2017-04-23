package com.example.sandwraith8.java_project.features.search;

/**
 * Created by sandwraith8 on 21/04/2017.
 */



        import java.util.ArrayList;

        import com.example.sandwraith8.java_project.models.SearchResult;


public interface SearchView {
    void onSearchDone(ArrayList<SearchResult> results, String query);
}

