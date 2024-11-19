package com.example.pr2_n;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Vibrator;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Alarm extends BroadcastReceiver {
    private MediaPlayer mediaPlayer;

    @Override
    public void onReceive(Context context, Intent intent) {
        long alarmTime = intent.getLongExtra("alarmTime", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String alarmTimeStr = sdf.format(new Date(alarmTime));

        Toast.makeText(context, "Будильник сработал! Время: " + alarmTimeStr, Toast.LENGTH_LONG).show();

        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(3000);

    }
}
