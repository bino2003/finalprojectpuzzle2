package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.finalprojectpuzzle.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnStart.startAnimation(AnimationUtils.loadAnimation(getBaseContext(),R.anim.my_animation));

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,ProfileClass.class);
                startActivity(intent);

            }
        });
        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,SettingsActivity.class);
                startActivity(intent);

            }
        });
binding.btnStart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent=new Intent(HomeActivity.this,PlayingStart.class);
        startActivity(intent);
    }
});
binding.logout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(HomeActivity.this,playerService.class);
        stopService(intent);
        finishAffinity();
    }
});
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent=new Intent(HomeActivity.this,playerService.class);
        stopService(intent);
    }
}