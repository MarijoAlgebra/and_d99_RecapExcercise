package org.bubulescu.recapexcercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] lvItems = {"Poziv", "SMS", "Pomoć"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, lvItems);

        final ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);

                if (item.equals("Poziv")) {
                    intent = new Intent(MainActivity.this, CallActivity.class);
                }

                else if (item.equals("SMS")) {
                    intent = new Intent(MainActivity.this, SmsActivity.class);
                }

                else if (item.equals("Pomoć")) {
                    intent = new Intent(MainActivity.this, PomocActivity.class);
                }

                if (intent != null) startActivity(intent);
            }
        });
    }

}
