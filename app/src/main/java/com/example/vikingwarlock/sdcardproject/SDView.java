package com.example.vikingwarlock.sdcardproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

public class SDView extends AppCompatActivity {

    //    List<Map<String,Object>> list;
    List<GridItem> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdview);
        GridView gv = (GridView) findViewById(R.id.gridView);
        if (gv != null) {

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    GridItem item = datalist.get(position);
                    Intent intent=new Intent();
                    intent.setClass(SDView.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("result",item);
                    intent.putExtras(bundle);
                    setResult(2,intent);
                    finish();
                }
            });
        }
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
        datalist = SDCardHelper.getFileList();
        bindData();
    }

    private void bindData() {
        GridView gridView = (GridView) findViewById(R.id.gridView);
        GridItemAdapter adapter = new GridItemAdapter(null, null, null, this);
        adapter.setupData(datalist);
        if (gridView != null)
            gridView.setAdapter(adapter);
    }

}
