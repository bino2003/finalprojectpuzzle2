package com.example.finalprojectpuzzle;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
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
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
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
        int PersonLevel=0;
        int pos= position;

        sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        int totalPoint=sharedPreferences.getInt("playerPoint",0);
        int unlockpoint=levelArrayList.get(pos).getUnlock_points();
        if (totalPoint>=unlockpoint){
            holder.closed.setImageResource(R.drawable.seo);
            PersonLevel++;
            editor.putInt("PersonLevel",PersonLevel);

            holder.linearlayout_numplayerpoint.setVisibility(View.VISIBLE);
            holder.linearlayout_nimallpoint.setVisibility(View.GONE);
            holder.numberPlayerPoint.setText(String.valueOf(totalPoint));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItem.onclick(levelArrayList.get(pos).getLevel1());
                }
            });
        }else {

            holder.closed.setImageResource(R.drawable.closed);
        }
        holder.Level.setText(String.valueOf(levelArrayList.get(position).getLevel1()));


        holder.Num_allPoint.setText(String.valueOf(levelArrayList.get(position).getUnlock_points()));
    }

    @Override
    public int getItemCount() {
        return levelArrayList.size();
    }
}
class LevelViewHolder extends RecyclerView.ViewHolder{
    TextView Level;
View linearlayout_numplayerpoint;
    TextView Num_allPoint;
TextView numberPlayerPoint;
View linearlayout_nimallpoint;
    ImageView closed;
    public LevelViewHolder(@NonNull ItemlevelBinding binding) {

        super(binding.getRoot());
        closed=binding.imageView2;

        linearlayout_nimallpoint=binding.linearlayoutNimallpoint;
        numberPlayerPoint=binding.numYourpoint;
        linearlayout_numplayerpoint=binding.linearlayoutNumplayerpoint;
        Num_allPoint=binding.numAllpoint;


        Level=binding.numLevel;
    }
}
