package com.example.ussd_auto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "main: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.requestUSSD);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this, XXXX.class));
                dailNumber("143");

            }
        });

    }

    private void dailNumber(String code) {
        String ussdCode = "*" + code + Uri.encode("#");
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussdCode));
        startActivity(intent);
        Log.e(TAG, intent.getDataString().toString());
    }
}
