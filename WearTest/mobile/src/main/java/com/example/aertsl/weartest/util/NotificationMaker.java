package com.example.aertsl.weartest.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import com.example.aertsl.weartest.R;

/**
 * Created by aertsl on 29-12-2014.
 */
public class NotificationMaker {

    private Context context;

    public NotificationMaker(Context context)
    {
        this.context = context;
    }

    public void createNotif() {



        NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.setBigContentTitle("Page 2").bigText("This is a lot of text how are you reading this oh my god").build();

        Notification notif2 =
                new NotificationCompat.Builder(context)
                        .setStyle(bigStyle)
                        .setContentText("Hello World!").build();

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.watch_icon);
        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                        .setHintHideIcon(true)
                        .addPage(notif2)
                        .setBackground(bitmap);

        Notification notif1 =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.common_signin_btn_icon_dark)
                        .setContentTitle("My notification")
                        .extend(wearableExtender)
                        .setContentText("Hello World!").build();


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notif1);
    }
}
