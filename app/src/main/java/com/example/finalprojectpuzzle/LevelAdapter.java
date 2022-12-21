package com.example.finalprojectpuzzle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectpuzzle.databinding.ItemlevelBinding;

import java.util.ArrayList;

public class LevelAdapter extends RecyclerView.Adapter<LevelViewHolder> {
    ArrayList<Level> levelArrayList;
    Context context;

    public LevelAdapter(ArrayList<Level> levelArrayList, Context context) {
        this.levelArrayList = levelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LevelViewHolder levelViewHolder= new LevelViewHolder(ItemlevelBinding.inflate(LayoutInflater.from(parent.getContext())));
        return levelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
holder.Level.setText(levelArrayList.get(position).getLevel1());


        holder.Num_allPoint.setText(levelArrayList.get(position).getUnlock_points());
        holder.closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return levelArrayList.size();
    }
}
class LevelViewHolder extends RecyclerView.ViewHolder{
TextView Level;
TextView Num_q;
TextView Num_allPoint;
TextView Num_PlayerPoint;
ImageView closed;
    public LevelViewHolder(@NonNull ItemlevelBinding binding) {

        super(binding.getRoot());
        closed=binding.imageView2;
        Num_allPoint=binding.numAllpoint;
        Num_PlayerPoint=binding.numYourpoint;
        Num_q=binding.numQ;
        Level=binding.level;
    }
}
