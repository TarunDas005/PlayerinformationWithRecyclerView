package com.example.bs151.playerinformationwithrecyclerview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerDetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView nameTextView, battingStyleTextView, bowlingStyleTextView, battingAverageT20TextView, bowlingAverageT20TextView, battingAverageODITextView, bowlingAverageODITextView, roleTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        imageView= (ImageView) findViewById(R.id.imageView);
        TextView nameTextView= (TextView) findViewById(R.id.nameTextView);
        TextView battingStyleTextView= (TextView) findViewById(R.id.battingStyleTextView);
        TextView bowlingStyleTextView= (TextView) findViewById(R.id.bowlingStyleTextView);
        TextView battingAverageT20TextView= (TextView) findViewById(R.id.battingAverageT20TextView);
        TextView bowlingAverageT20TextView= (TextView) findViewById(R.id.bowlingAverageT20TextView);
        TextView battingAverageODITextView= (TextView) findViewById(R.id.battingAverageODITextView);
        TextView bowlingAverageODITextView= (TextView) findViewById(R.id.bowlingAverageODITextView);
        TextView roleTextView= (TextView) findViewById(R.id.roleTextView);
        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("imageId");
        String name=getIntent().getStringExtra("name");
        String batStyle=getIntent().getStringExtra("battingStyle");
        String bowlingStyle=getIntent().getStringExtra("bowlingStyle");
        String batingAvgInT20=getIntent().getStringExtra("batingAvgInT20");
        String batingAvgInODI=getIntent().getStringExtra("batingAvgInODI");
        String bowlingAvgInT20=getIntent().getStringExtra("bowlingAvgInT20");
        String bowlingAvgInODI=getIntent().getStringExtra("bowlingAvgInODI");
        String role=getIntent().getStringExtra("role");
        imageView.setImageBitmap(bitmap);
        nameTextView.setText(name);
        battingStyleTextView.setText(batStyle);
        bowlingStyleTextView.setText(bowlingStyle);
        battingAverageT20TextView.setText(batingAvgInT20);
        bowlingAverageT20TextView.setText(bowlingAvgInT20);
        battingAverageODITextView.setText(batingAvgInODI);
        bowlingAverageODITextView.setText(bowlingAvgInODI);
        roleTextView.setText(role);

    }
}
