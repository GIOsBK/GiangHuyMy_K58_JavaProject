package com.example.sandwraith8.java_project.activities;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import com.example.sandwraith8.java_project.R;
import com.example.sandwraith8.java_project.adapters.CheckAdapter;
import com.example.sandwraith8.java_project.adapters.ComicAdapter;
import com.example.sandwraith8.java_project.databinding.ActivityComicBinding;
import com.example.sandwraith8.java_project.features.check.CheckPresenter;
import com.example.sandwraith8.java_project.features.check.CheckView;
import com.example.sandwraith8.java_project.features.display.contents.DisplayContentPresenter;
import com.example.sandwraith8.java_project.features.display.contents.DisplayContentView;
import com.example.sandwraith8.java_project.models.RuleResult;
import com.example.sandwraith8.java_project.models.SearchResult;

public class ComicActivity extends MyActivity implements
        DisplayContentView, CheckView {

    private ActivityComicBinding mBinding;

    private DisplayContentPresenter mDisplayContentPresenter;

    private CheckPresenter mCheckPresenter;

    private ArrayList<String> mContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_comic);
        mDisplayContentPresenter = new DisplayContentPresenter(this);
        mCheckPresenter = new CheckPresenter(this);
        String name = getIntent().getStringExtra("name");
        String parent = getIntent().getStringExtra("parent");
        setUpActionBar(name);
        mDisplayContentPresenter.getAllContent(parent + "/" + name);
    }

    @Override
    public void getAllContentDone(ArrayList<String> contents) {
        mContents = contents;
        mBinding.checkProgressBar.setVisibility(View.GONE);
        if (getIntent().getStringExtra("query") != null)
            mBinding.contentListView.setAdapter(
                    new ComicAdapter(this, contents, getIntent().getStringExtra("query")));
        else
            mBinding.contentListView.setAdapter(
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contents));
        if (getIntent().getIntExtra("line", 0) > 0)
            mBinding.contentListView.setSelection(getIntent().getIntExtra("line", 0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.comic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return false;
            case R.id.action_filter:
                mBinding.contentListView.setVisibility(View.GONE);
                mBinding.checkProgressBar.setVisibility(View.VISIBLE);
                if (mContents != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mCheckPresenter.check(mContents);
                        }
                    }).start();
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void getAllWordInvalidDone(final RuleResult results) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<RuleResult> arr = new ArrayList<RuleResult>();
                arr.add(results);
                mBinding.contentListView.setAdapter(new CheckAdapter(getBaseContext(), arr));
                mBinding.checkProgressBar.setVisibility(View.GONE);
                mBinding.contentListView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void getAllWordInvalidSuccess(ArrayList<SearchResult> results) {

    }

    @Override
    public void updateWordInvalidDone(SearchResult result) {

    }
}

