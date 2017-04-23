package com.example.sandwraith8.java_project.features.display.folders;

/**
 * Created by sandwraith8 on 21/04/2017.
 */

import java.io.File;
import java.util.ArrayList;


public interface DisplayFolderView {
    void makeRootFolderDone(File rootFolder);
    void getAllFolderDone(ArrayList<String> folderNames);
}
