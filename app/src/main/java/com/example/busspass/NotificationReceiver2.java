package com.example.busspass;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class NotificationReceiver2 extends BroadcastReceiver {
    Vibrator vibrator;
    MondayDatabaseHelper mondaydb;
    TuesdayDatabaseHelper tuesdaydb;
    WednesdayDatabaseHelper wednesdaydb;
    ThursdayDatabaseHelper thursdaydb;
    FridayDatabaseHelper fridaydb;
    SaturdayDatabaseHelper saturdaydb;
    SundayDatabaseHelper sundaydb;

    @Override
    public void onReceive(Context context, Intent intent) {
        //MainActivity inst = MainActivity.instance();
        //inst.setAlarmText("Alarm! Wake up! Wake up!");
        Toast.makeText(context, "TIme is up", Toast.LENGTH_SHORT).show();
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        Log.d("RecyclerView ","sfssgsgsfsfbfsbfsvdfvdfbdf");

        mondaydb = new MondayDatabaseHelper(context);
        tuesdaydb = new TuesdayDatabaseHelper(context);
        wednesdaydb = new WednesdayDatabaseHelper(context);
        thursdaydb = new ThursdayDatabaseHelper(context);
        fridaydb = new FridayDatabaseHelper(context);
        saturdaydb = new SaturdayDatabaseHelper(context);
        sundaydb = new SundayDatabaseHelper(context);

        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, SplashActivity.class), 0);

        String dayString= intent.getStringExtra("dayday");
        // Log.i("to checkkkkkkkkkkkk","day"+dayString);
        if(dayString.equals("Monday"))
            mondaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);
        else if(dayString.equals("Tuesday")) {
            tuesdaydb.updatedata(intent.getStringExtra("id"),  intent.getBooleanExtra("notify", false),false);
        }
        else if(dayString.equals("Wednesday"))
            wednesdaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);
        else if(dayString.equals("Thursday"))
            thursdaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);
        else if(dayString.equals("Friday"))
            fridaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);
        else if(dayString.equals("Saturday"))
            saturdaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);
        else if(dayString.equals("Sunday"));
        sundaydb.updatedata(intent.getStringExtra("id"),intent.getBooleanExtra("notify",false),false);

        String CHANNEL_ID = "reminder_channel";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Reminder";
            String description = "Used to remind the user of the buses";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.home)
                        .setContentTitle("Bus At")
                        .setContentText("Your Bus is at Gate No.1 and will be leaving soon");
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(Integer.parseInt(intent.getStringExtra("id")), mBuilder.build());
        final Handler handler = new Handler();



//




        //this will send a notification message
//        ComponentName comp = new ComponentName(context.getPackageName(),
//                AlarmService.class.getName());
//        //startWakefulService(context, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
    }


}
