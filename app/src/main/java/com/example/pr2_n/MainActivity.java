package com.example.pr2_n;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    Button btnStartTimer;
    EditText edtMinutes ;
    EditText edtHours;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHours = findViewById(R.id.edtHours);
        edtMinutes = findViewById(R.id.edtMinutes);
        btnStartTimer = findViewById(R.id.btnStarTimer);

        btnStartTimer.setOnClickListener(v -> {
            int hours = Integer.parseInt(edtHours.getText().toString());
            int minutes = Integer.parseInt(edtMinutes.getText().toString());

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hours);
            calendar.set(Calendar.MINUTE, minutes);
            calendar.set(Calendar.SECOND, 0);

            long alarmTime = calendar.getTimeInMillis();

            Intent intent = new Intent(MainActivity.this, Alarm.class);
            intent.putExtra("alarmTime", alarmTime);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTime, PendingIntent.getBroadcast(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE));

            Toast.makeText(MainActivity.this, "Будильник установлен", Toast.LENGTH_SHORT).show();
        });
    }
}