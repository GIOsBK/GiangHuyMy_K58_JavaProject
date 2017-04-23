package com.example.sandwraith8.java_project.features.display.folders;

/**
 * Created by sandwraith8 on 21/04/2017.
 */


import android.os.Environment;

import com.example.sandwraith8.java_project.common.Constant;

import java.io.File;
import java.util.ArrayList;


public class DisplayFolderPresenter {

    private DisplayFolderView mDisplayFolderView;

    public DisplayFolderPresenter(DisplayFolderView aDisplayFolderView) {
        mDisplayFolderView = aDisplayFolderView;
    }

    public void makeRootFolder() {
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + Constant.DIRECTORY );
        if (!folder.exists())
            folder.mkdirs();
        mDisplayFolderView.makeRootFolderDone(folder);
    }

    public void getAllFolder(File rootFolder) {
        ArrayList<String> comicNames = new ArrayList<>();
        File[] files = rootFolder.listFiles();
        for (File inFile : files) {
            if (inFile.isDirectory()) {
                comicNames.add(inFile.getName());
            }
        }
        mDisplayFolderView.getAllFolderDone(comicNames);
    }
}
