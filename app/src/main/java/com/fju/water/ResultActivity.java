package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        float fee = intent.getFloatExtra("FEE",0);
        TextView feeText = findViewById(R.id.fee);
        int n = (int) (fee*10 + 0.5f); //取到 "小數點後一位" 四捨五入
        float a = (float)n/10;
        feeText.setText(a+"");
        Log.d("ResultActivity",a + " ");
    }
}
