package com.example.vikingwarlock.sdcardproject;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class SDView extends AppCompatActivity {

//    List<Map<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!SDCardHelper.isExternalStorageReadable()) {
            Toast.makeText(this, "SDCard Not Readable", Toast.LENGTH_LONG).show();
            return;
        }
        if (!SDCardHelper.isExternalStorageWritable()) {
            Toast.makeText(this, "SDCard Not Writable", Toast.LENGTH_LONG).show();
            return;
        }
//        Toast.makeText(this,"Permission granted!!",Toast.LENGTH_LONG).show();
        Toast.makeText(this, SDCardHelper.storagePath(), Toast.LENGTH_LONG).show();
//        System.out.println(SDCardHelper.getFileList());
        bindData();
    }

    private void bindData() {
        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridItemAdapter adapter = new GridItemAdapter(null, null, null, this);
        adapter.setupData(SDCardHelper.getFileList());
        if (gridView != null)
            gridView.setAdapter(adapter);
    }

}
