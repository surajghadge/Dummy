package com.practise.dummy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.practise.dummy.network.vegSnacksData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","onCreate()");
    }

    public void FetchData(View view){
        Log.e("MainActivity","FetchData()");
        //Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show();
        /*vegSnacksData  vegSnacksData=new vegSnacksData();
        vegSnacksData.getVegSnacksData(this);*/
        TestHelper testHelper=new TestHelper(this);

    }
}
