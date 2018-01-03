package org.bubulescu.recapexcercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    Button bSend, bFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        bSend = findViewById(R.id.bSendSms);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SmsActivity.this, R.string.sendingSMS, Toast.LENGTH_SHORT).show();
            }
        });

        bFinish = findViewById(R.id.bFinish);
        bFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SmsActivity.this, R.string.goodbye, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Intent intent = getIntent();
        String brojTelefona;
        TextView tvBrojTelefona = findViewById(R.id.tvBrojtelefonaSms);
        if (intent.hasExtra(MainActivity.BROJ_TELEFONA)) {
            brojTelefona = intent.getStringExtra(MainActivity.BROJ_TELEFONA);
            tvBrojTelefona.setText(brojTelefona);
        }
    }
}
