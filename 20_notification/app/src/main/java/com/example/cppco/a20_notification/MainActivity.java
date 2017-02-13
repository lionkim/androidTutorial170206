package com.example.cppco.a20_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick (View v) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

//        Notification.Builder builder = new Notification.Builder(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sunnyshores);
        Intent intent = new Intent(this, Notification.class);
        PendingIntent pIndent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("TITLE");
        builder.setContentText("TEXT");
        builder.setSubText("SUB TEXT");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);
        builder.setContentIntent(pIndent);
        builder.setAutoCancel(true);

        manager.notify(1234, builder.build());
    }
}



































