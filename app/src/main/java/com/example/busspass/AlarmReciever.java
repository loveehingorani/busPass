package com.example.busspass;

 import android.app.Activity;
        import android.content.BroadcastReceiver;
        import android.content.ComponentName;
        import android.content.Context;
        import android.content.Intent;
        import android.media.Ringtone;
        import android.media.RingtoneManager;
        import android.net.Uri;
        import android.os.Handler;
 import android.os.Vibrator;
 import android.util.Log;
 import android.widget.Toast;
//import android.support.v4.content.WakefulBroadcastReceiver;


public class AlarmReciever extends BroadcastReceiver {
    Vibrator vibrator;
    MondayDatabaseHelper mondaydb;
    TuesdayDatabaseHelper tuesdaydb;
    WednesdayDatabaseHelper wednesdaydb;
    ThursdayDatabaseHelper thursdaydb;
    FridayDatabaseHelper fridaydb;
    SaturdayDatabaseHelper saturdaydb;
    SundayDatabaseHelper sundaydb;
    /*
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"TIme is up",Toast.LENGTH_SHORT).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);


    }*/

    @Override
    public void onReceive(Context context, Intent intent) {
        //MainActivity inst = MainActivity.instance();
        //inst.setAlarmText("Alarm! Wake up! Wake up!");
        Toast.makeText(context,"Bus Time", Toast.LENGTH_SHORT).show();
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to



        mondaydb= new MondayDatabaseHelper(context);
        tuesdaydb=new TuesdayDatabaseHelper(context);
        wednesdaydb=new WednesdayDatabaseHelper(context);
        thursdaydb=new ThursdayDatabaseHelper(context);
        fridaydb=new FridayDatabaseHelper(context);
        saturdaydb=new SaturdayDatabaseHelper(context);
        sundaydb=new SundayDatabaseHelper(context);

        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        final Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ringtone.stop();
                String dayString= intent.getStringExtra("day");
                Log.i("to checkkkkkkkkkkkk","day"+dayString);
                if(dayString.equals("Monday"))
                     mondaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));
                else if(dayString.equals("Tuesday")) {
                    tuesdaydb.updatedata(intent.getStringExtra("id"), false, intent.getBooleanExtra("notify", false));
                    Log.i("to checkkkkkkkkkkkk","day"+dayString);
                }
                else if(dayString.equals("Wednesday"))
                    wednesdaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));
                else if(dayString.equals("Thursday"))
                    thursdaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));
                else if(dayString.equals("Friday"))
                    fridaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));
                else if(dayString.equals("Saturday"))
                    saturdaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));
                else if(dayString.equals("Sunday"));
                    sundaydb.updatedata(intent.getStringExtra("id"),false,intent.getBooleanExtra("notify",false));


            }
        }, 10000);


        //this will send a notification message
//        ComponentName comp = new ComponentName(context.getPackageName(),
//                AlarmService.class.getName());
//        //startWakefulService(context, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
    }


}
