package com.example.vikingwarlock.sdcardproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.*;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private final int REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(getApplicationContext());
        ImageLoader.getInstance().init(config.build());
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.jump);
        if (btn == null)
            return;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushToSDView(v);
            }
        });
    }


    public void pushToSDView(View view) {
        Intent intent = new Intent(this, SDView.class);
        startActivityForResult(intent, REQUESTCODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {
            if (requestCode == REQUESTCODE) {
                GridItem item = (GridItem) data.getSerializableExtra("result");
                ImageView imgview = (ImageView) findViewById(R.id.imageView);
                if (imgview!=null)
                    ImageLoader.getInstance().displayImage("file://" + item.filepath, imgview);
            }
        }
    }
}
