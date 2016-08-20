package com.example.bs151.playerinformationwithrecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by BS151 on 7/21/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Player> players=new ArrayList<Player>();
    Activity con;
    public RecyclerAdapter(Activity con,ArrayList<Player> players) {
        this.con=con;
        this.players=players;
    }


    @Override
    public int getItemViewType(int position) {
        Player player=players.get(position);
        if (player.getRole().equals("Allrounder")) {
            return 0;
        }else if(player.getRole().equals("Bowler")){
            return 1;
        }else if(player.getRole().equals("batsman")){
            return 2;
        }else{
            return 3;
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder = null;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.allrounder_layout,parent,false);
                recyclerViewHolder=new RecyclerViewHolder(con,view);
                break;
            case 1:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.bowler_layout,parent,false);
                recyclerViewHolder=new RecyclerViewHolder(con,view);
                break;
            case 2:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.batsman_layout,parent,false);
                recyclerViewHolder=new RecyclerViewHolder(con,view);
                break;
            case 3:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.wicketkeeper_layout,parent,false);
                recyclerViewHolder=new RecyclerViewHolder(con,view);
                break;
        }
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.imageView.setImageResource(player.getImageId());
        holder.nameTextView.setText(player.getName());
        holder.battingStyleTextView.setText("Bat. style: " + player.getBatingStyle());
        holder.bowlingStyleTextView.setText("Bow. style: " + player.getBowlingStyle());
        holder.battingAverageT20TextView.setText("Bat. Avg(T20): " + player.getBatingAvgInT20() + "");
        holder.battingAverageODITextView.setText("Bat. Avg(ODI): " + player.getBatingAvgInODI() + "");
        holder.bowlingAverageT20TextView.setText("Bow. Avg(T20): " + player.getBowlingAvgInT20() + "");
        holder.bowlingAverageODITextView.setText("Bow. Avg(ODI): " + player.getBowlingAvgInODI() + "");
        holder.roleTextView.setText(player.getRole());
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Activity activity;
        ImageView imageView;
        TextView nameTextView, battingStyleTextView, bowlingStyleTextView, battingAverageT20TextView, bowlingAverageT20TextView, battingAverageODITextView, bowlingAverageODITextView, roleTextView;
        public RecyclerViewHolder(Activity activity,View view) {
            super(view);
            view.setOnClickListener(this);
            this.activity=activity;
            imageView = (ImageView) view.findViewById(R.id.imageView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            battingStyleTextView = (TextView) view.findViewById(R.id.battingStyleTextView);
            bowlingStyleTextView = (TextView) view.findViewById(R.id.bowlingStyleTextView);
            battingAverageT20TextView = (TextView) view.findViewById(R.id.battingAverageT20TextView);
            bowlingAverageT20TextView = (TextView) view.findViewById(R.id.bowlingAverageT20TextView);
            battingAverageODITextView = (TextView) view.findViewById(R.id.battingAverageODITextView);
            bowlingAverageODITextView = (TextView) view.findViewById(R.id.bowlingAverageODITextView);
            roleTextView = (TextView) view.findViewById(R.id.roleTextView);
        }

        @Override
        public void onClick(View view) {
            ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
            TextView nameTextView= (TextView) view.findViewById(R.id.nameTextView);
            TextView battingStyleTextView= (TextView) view.findViewById(R.id.battingStyleTextView);
            TextView bowlingStyleTextView= (TextView) view.findViewById(R.id.bowlingStyleTextView);
            TextView battingAverageT20TextView= (TextView) view.findViewById(R.id.battingAverageT20TextView);
            TextView bowlingAverageT20TextView= (TextView) view.findViewById(R.id.bowlingAverageT20TextView);
            TextView battingAverageODITextView= (TextView) view.findViewById(R.id.battingAverageODITextView);
            TextView bowlingAverageODITextView= (TextView) view.findViewById(R.id.bowlingAverageODITextView);
            TextView roleTextView= (TextView) view.findViewById(R.id.roleTextView);
            imageView.buildDrawingCache();
            Bitmap bitmap = imageView.getDrawingCache();

            String name= nameTextView.getText().toString();
            String battingStyle=battingStyleTextView.getText().toString();
            String bowlingStyle=bowlingStyleTextView.getText().toString();
            String batingAvgInT20=battingAverageT20TextView.getText().toString();
            String batingAvgInODI=battingAverageODITextView.getText().toString();
            String bowlingAvgInT20=bowlingAverageT20TextView.getText().toString();
            String bowlingAvgInODI=bowlingAverageODITextView.getText().toString();
            String role=roleTextView.getText().toString();
            Intent intent=new Intent(activity,PlayerDetailsActivity.class);
            intent.putExtra("imageId",bitmap);
            intent.putExtra("name",name);
            intent.putExtra("battingStyle",battingStyle);
            intent.putExtra("bowlingStyle",bowlingStyle);
            intent.putExtra("batingAvgInT20",batingAvgInT20);
            intent.putExtra("batingAvgInODI",batingAvgInODI);
            intent.putExtra("bowlingAvgInT20",bowlingAvgInT20);
            intent.putExtra("bowlingAvgInODI",bowlingAvgInODI);
            intent.putExtra("role",role);
            activity.startActivity(intent);
        }
    }
    @Override
    public int getItemCount() {
        return players.size();
    }
}
