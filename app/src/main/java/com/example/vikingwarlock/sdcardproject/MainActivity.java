package com.example.vikingwarlock.sdcardproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.jump);
        if (btn==null)
            return;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushToSDView(v);
            }
        });
    }


    public void pushToSDView(View view){
        Intent intent=new Intent(this,SDView.class);
        startActivity(intent);

    }
}
