package com.example.bs151.playerinformationwithrecyclerview;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Player> players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        players=new ArrayList<Player>();
        createPlayerArrayList();
        adapter=new RecyclerAdapter(MainActivity.this,players);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    public void createPlayerArrayList(){
        try{
            JSONObject jsonObject=new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray=(JSONArray) jsonObject.getJSONArray("info");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object= (JSONObject) jsonArray.get(i);
                String url=object.getString("url");
                int resourceImage = this.getResources().getIdentifier(url, "drawable", this.getPackageName());
                String name= object.getString("name");
                String battingStyle=object.getString("Batting_Style");
                String bowlingStyle=object.getString("Bowling_Style");
                double batingAvgInT20=object.getDouble("Batting_Average_T20");
                double batingAvgInODI=object.getDouble("Batting_Average_ODI");
                double bowlingAvgInT20=object.getDouble("Bowling_Average_T20");
                double bowlingAvgInODI=object.getDouble("Bowling_Average_ODI");
                String role=object.getString("role");
                Player player=new Player(resourceImage,name,battingStyle,bowlingStyle,batingAvgInT20,batingAvgInODI,bowlingAvgInT20,bowlingAvgInODI,role);
                players.add(player);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset(){
        String json=null;
        try{
            InputStream textInfo=getAssets().open("information.json");
            int size=textInfo.available();
            byte[] buffer=new byte[size];
            textInfo.read(buffer);
            textInfo.close();
            json=new String(buffer,"UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}
