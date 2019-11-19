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
 import android.widget.Toast;
//import android.support.v4.content.WakefulBroadcastReceiver;


public class AlarmReciever extends BroadcastReceiver {
    Vibrator vibrator;
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
        Toast.makeText(context,"TIme is up", Toast.LENGTH_SHORT).show();
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
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
            }
        }, 10000);


        //this will send a notification message
//        ComponentName comp = new ComponentName(context.getPackageName(),
//                AlarmService.class.getName());
//        //startWakefulService(context, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
    }


}
