package com.example.finalprojectpuzzle;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.jar.JarEntry;

public class myJobService extends JobService {
    public static final String CHANNEL_ID="1";
boolean stop=false;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
  notification(jobParameters);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
stop=true;
        return false;
    }
    public void notification(JobParameters jobParameters){
        if (stop){
            jobFinished(jobParameters,false);
            return;
        }
        Intent intent=new Intent(getBaseContext(),PlayingStart.class);
        PendingIntent pi = PendingIntent.getActivity(myJobService.this,0,intent,0);
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel(CHANNEL_ID,"channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder= new NotificationCompat.Builder(myJobService.this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("notification title");
        builder.setContentText("notification text ");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.addAction(R.drawable.ic_launcher_background,"action",pi);
        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(myJobService.this);
        managerCompat.notify(1,builder.build());
    }
}

