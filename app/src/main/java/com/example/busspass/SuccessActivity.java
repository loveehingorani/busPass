package com.example.busspass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    private TextView tDate,tTime,tMode,tAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        Intent i=getIntent();

        tDate=(TextView) findViewById(R.id.transaction_date);
      //  tTime=(TextView) findViewById(R.id.transaction_time);
        tAmount=(TextView) findViewById(R.id.amount_paid);
        tMode=(TextView) findViewById(R.id.payment_mode);

        tAmount.setText(i.getStringExtra("checksum_amount"));
        tDate.setText(i.getStringExtra("checksum_date"));
      //  tTime.setText(i.getStringExtra("checksum_time"));
        tMode.setText(i.getStringExtra("checksum_mode"));


    }

    @Override
    public void onBackPressed() {
        finish();

        startActivity(new Intent(SuccessActivity.this,MainActivity.class));
        super.onBackPressed();
    }
}
