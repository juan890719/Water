package com.fju.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed_Month;
    EditText ed_Next;
    boolean isNext = false;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG , "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG , "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG , "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG , "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG , "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG , "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ed_Month = findViewById(R.id.month);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthString = ed_Month.getText().toString();
                float fee = 0;
                if (!TextUtils.isEmpty(monthString)) {
                    float degree = Float.parseFloat(monthString);
                    if (degree >= 1 && degree <= 10) {
                        fee = degree * 7.35f;
                    } else if (degree >= 11 && degree <= 30) {
                        fee = degree * 9.45f - 21;
                    } else if (degree >= 31 && degree <= 50) {
                        fee = degree * 11.55f - 84;
                    } else {
                        fee = degree * 12.075f - 110.25f;
                    }
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("FEE",fee);
                    startActivity(intent);
            /*new AlertDialog.Builder(MainActivity.this)
                    .setTitle("本月抄表")
                    .setMessage("費用 : " + fee)
                    .setPositiveButton("OK", null)
                    .show();*/
                } else {
                    String nextString = ed_Next.getText().toString();
                    if (!TextUtils.isEmpty(nextString)) {
                        float degree = Float.parseFloat(nextString);

                        if (degree >= 1 && degree <= 20) {
                            fee = degree * 7.35f;
                        } else if (degree >= 21 && degree <= 60) {
                            fee = degree * 9.45f - 42;
                        } else if (degree >= 61 && degree <= 100) {
                            fee = degree * 11.55f - 168;
                        } else {
                            fee = degree * 12.075f - 220.5f;
                        }
                        /*new AlertDialog.Builder(MainActivity.this)
                                .setTitle("隔月抄表")
                                .setMessage("費用 : " + fee)
                                .setPositiveButton("OK", null)
                                .show();*/
                    } else {
                        /*new AlertDialog.Builder(MainActivity.this)
                                .setTitle("錯誤")
                                .setMessage("無法計算")
                                .setPositiveButton("OK", null)
                                .show();*/
                    }
                }
            }
        });
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ? "Evert other month" : "Month");
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
