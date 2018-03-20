package com.example.hlchen.sports_app.Adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hlchen.sports_app.Class.Tyq_Class;
import com.example.hlchen.sports_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hlchen on 2018/3/7.
 */

public class Tyq_rec_Adapter extends RecyclerView.Adapter<Tyq_rec_Adapter.Tyq_rec_ViewHolder>{
    private List<Tyq_Class> mlist ;

    public Tyq_rec_Adapter(List<Tyq_Class> mlist) {
        this.mlist = mlist;
    }

    @Override
    public Tyq_rec_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sports_v1_rec_item,parent,false);
        final Tyq_rec_ViewHolder   viewHolder = new Tyq_rec_ViewHolder (view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Tyq_rec_ViewHolder holder, int position) {
        Tyq_Class t_tyq ;
        t_tyq = mlist.get(position);
        holder.Time.setText(t_tyq.getTime());
        holder.Img.setImageBitmap(t_tyq.getPic());
        holder.nr.setText(t_tyq.getUser_nr());
        holder.tx.setImageBitmap(t_tyq.getTx());
        holder.User_name.setText(t_tyq.getUser_Name());

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class Tyq_rec_ViewHolder extends RecyclerView.ViewHolder{
        TextView User_name;
        TextView Time;
        TextView nr;
        ImageView tx;
        ImageView Img ;
        private View mview;
        public Tyq_rec_ViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            tx = (ImageView) itemView.findViewById(R.id.Sp_V1_R_tx);
            Img = (ImageView) itemView.findViewById(R.id.Sp_V1_R_pic);
            User_name = (TextView)itemView.findViewById(R.id.Sp_V1_R_Name);
            nr = (TextView)itemView.findViewById(R.id.Sp_V1_R_text);
            Time = (TextView)itemView.findViewById(R.id.Sp_V1_R_Time);
        }
    }
}
