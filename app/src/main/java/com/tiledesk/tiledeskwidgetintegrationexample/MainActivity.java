package com.tiledesk.tiledeskwidgetintegrationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View v){
        v.getContext().startActivity(new Intent(v.getContext(), TiledeskActivity.class));
    }
    public void onClickInject(View v){
        v.getContext().startActivity(new Intent(v.getContext(), TiledeskInjectActivity.class));
    }
}