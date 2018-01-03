package org.bubulescu.recapexcercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BROJ_TELEFONA = "broj_telefona";
    String brojTelefona;
    EditText etBrojTelefona;
    String[] lvItems = {"Poziv", "SMS", "Pomoć"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBrojTelefona = findViewById(R.id.etBroj);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, lvItems);

        final ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                brojTelefona = etBrojTelefona.getText().toString();

                if (item.equals("Poziv")) {
                    intent = new Intent(MainActivity.this, CallActivity.class);
                    intent.putExtra(BROJ_TELEFONA, brojTelefona);
                }

                else if (item.equals("SMS")) {
                    intent = new Intent(MainActivity.this, SmsActivity.class);
                    intent.putExtra(BROJ_TELEFONA, brojTelefona);
                }

                else if (item.equals("Pomoć")) {
                    intent = new Intent(MainActivity.this, PomocActivity.class);
                }

                if (intent != null) startActivity(intent);
            }
        });
    }

}
