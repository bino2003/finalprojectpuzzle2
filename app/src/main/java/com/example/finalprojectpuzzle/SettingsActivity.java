package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.finalprojectpuzzle.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity {
ActivitySettingsBinding binding;
    public static final int JOB_ID=1;
    boolean is_player=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        JobScheduler jobScheduler= (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        binding.Notifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ComponentName componentName=new ComponentName(getBaseContext(),myJobService.class);
                    JobInfo jobInfo=null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
                         jobInfo=new JobInfo.Builder(JOB_ID,componentName)
                                .setMinimumLatency(24*60*60*1000)
                                .build();
                    }
                    jobScheduler.schedule(jobInfo);
                }else {
jobScheduler.cancel(JOB_ID);
                }

            }
        });
        binding.music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent intent=new Intent(SettingsActivity.this,playerService.class);

                if (b){
                    if (is_player)
                        startService(intent);
                    is_player=false;

                }else {
                    stopService(intent);
                    is_player=true;

                }
                }
            }
        );
    }


}