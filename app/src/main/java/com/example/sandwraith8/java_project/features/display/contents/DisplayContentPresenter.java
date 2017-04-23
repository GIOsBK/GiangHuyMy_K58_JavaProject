package com.example.sandwraith8.java_project.features.display.contents;

/**
 * Created by sandwraith8 on 21/04/2017.
 */


import android.os.Environment;
import android.util.Log;

import com.example.sandwraith8.java_project.common.Constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class DisplayContentPresenter {

    private DisplayContentView mDisplayContentView;

    public DisplayContentPresenter(DisplayContentView aDisplayContentView) {
        mDisplayContentView = aDisplayContentView;
    }

    public void getAllContent(String path) {
        File file = new File(Environment.getExternalStorageDirectory() +
                File.separator + Constant.DIRECTORY + "/" + path);
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
//                if (!line.equals("")) {
//                    lines.add(line);
//                } else {
//                    if (lines.size() > 1 && !lines.get(lines.size() - 1).equals(""))
//                        lines.add(line);
//                }
                lines.add(line);
            }
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
        }
        mDisplayContentView.getAllContentDone(lines);
    }

}

