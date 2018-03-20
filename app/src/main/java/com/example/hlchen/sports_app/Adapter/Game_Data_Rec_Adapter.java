package com.example.hlchen.sports_app.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hlchen.sports_app.Class.Game_Data_Class;
import com.example.hlchen.sports_app.R;

import java.util.List;

/**
 * Created by Hlchen on 2018/3/15.
 */

public class Game_Data_Rec_Adapter extends RecyclerView.Adapter<Game_Data_Rec_Adapter.Game_Data_rec_ViewHolder>{

    private List<Game_Data_Class> mlist;

    public Game_Data_Rec_Adapter(List<Game_Data_Class> mlist) {
        this.mlist = mlist;
    }

    @Override
    public Game_Data_rec_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.game_date_rec_item,parent,false);
        Game_Data_rec_ViewHolder viewHolder = new Game_Data_rec_ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Game_Data_rec_ViewHolder holder, int position) {
        Game_Data_Class game_data_class = mlist.get(position);
        holder.Team_name.setText(game_data_class.getTeam_Name());
        holder.tx.setImageBitmap(game_data_class.getTeam_Ui());
        holder.Place.setText(game_data_class.getPlace());
        holder.Time.setText(game_data_class.getTime());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class Game_Data_rec_ViewHolder extends RecyclerView.ViewHolder{
        TextView Team_name;
        TextView Time;
        ImageView tx;
        TextView Place;
        private View mview;
        public Game_Data_rec_ViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            tx = (ImageView) itemView.findViewById(R.id.Sp_V2_R_tx);
            Time = (TextView)itemView.findViewById(R.id.Sp_V2_R_Time);
            Place = (TextView)itemView.findViewById(R.id.Sp_V2_R_Plcae);
            Team_name = (TextView)itemView.findViewById(R.id.Sp_V2_R_Name);
        }
    }
}
