package com.example.vikingwarlock.sdcardproject;

import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by vikingwarlock on 16-9-18.
 * This class is used to operate the filesystem
 */

public class SDCardHelper {


    static public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    static public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    static public String storagePath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures/Screenshots";
    }

    static public List<GridItem> getFileList(){
        List<GridItem> list=new ArrayList<>();
        try {
            File sdPath = new File(SDCardHelper.storagePath());
            if (sdPath.listFiles().length > 0) {
                for (File file : sdPath.listFiles()) {
                    GridItem item=new GridItem();
                    item.filename=file.getName();
                    item.filepath=file.getAbsolutePath();
                    list.add(item);
                }
            }
        } catch (Exception e) {
            //
        }
        return list;
    }
}
