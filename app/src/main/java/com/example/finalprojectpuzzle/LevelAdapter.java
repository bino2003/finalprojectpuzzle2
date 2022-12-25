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
OnClickItem onClickItem;

    public LevelAdapter(ArrayList<Level> levelArrayList, Context context, OnClickItem onClickItem) {
        this.levelArrayList = levelArrayList;
        this.context = context;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LevelViewHolder levelViewHolder= new LevelViewHolder(ItemlevelBinding.inflate(LayoutInflater.from(parent.getContext())));
        return levelViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {
        int pos= position;
        holder.Level.setText(String.valueOf(levelArrayList.get(position).getLevel1()));
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
onClickItem.onclick(levelArrayList.get(pos).getLevel1());
    }
});

        holder.Num_allPoint.setText(String.valueOf(levelArrayList.get(position).getUnlock_points()));
        holder.closed.setImageResource(R.drawable.closed);
    }

    @Override
    public int getItemCount() {
        return levelArrayList.size();
    }
}
class LevelViewHolder extends RecyclerView.ViewHolder{
    TextView Level;

    TextView Num_allPoint;

    ImageView closed;
    public LevelViewHolder(@NonNull ItemlevelBinding binding) {

        super(binding.getRoot());
        closed=binding.imageView2;
        Num_allPoint=binding.numAllpoint;


        Level=binding.numLevel;
    }
}
