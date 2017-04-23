package com.example.sandwraith8.java_project.features.search;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.example.sandwraith8.java_project.models.SearchResult;


/**
 * Created by sandwraith8 on 21/04/2017.
 */
public class SearchPresenter {

    private SearchView mSearchView;

    public SearchPresenter(SearchView aSearchView) {
        mSearchView = aSearchView;
    }

    public void search(String comicName, String query, ArrayList<String> filenames) {
        String key = getKeyWord(query);
        ArrayList<SearchResult> results = new ArrayList<>();
        for (String name :
                filenames) {
            File file = new File(Environment.getExternalStorageDirectory() +
                    File.separator + "Danh sách truyện/" + comicName + "/" + name);
            int count = 0;
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    count++;
                    if (line.toLowerCase().contains(key)) {
                        SearchResult searchResult = new SearchResult();
                        searchResult.setSection(file.getName());
                        searchResult.setContent(line);
                        searchResult.setLine(count);
                        results.add(searchResult);
                    }
                }
                br.close();
            } catch (IOException e) {
                //You'll need to add proper error handling here
            }
        }
        mSearchView.onSearchDone(results, query);
    }

    private String getKeyWord(String query) {
        return query.trim().replaceAll(" +", " ").toLowerCase();
    }

}

