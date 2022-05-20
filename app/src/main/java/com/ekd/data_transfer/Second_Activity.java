package com.ekd.data_transfer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity  {

    private  TextView uname, upass;
    private Button btn_Switch2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_Switch2 = findViewById(R.id.btn2_Switch);
        uname = findViewById(R.id.user_name_disp);
        upass = findViewById(R.id.user_pass_disp);




        String user_name = getIntent().getStringExtra("key_user");
        String user_password = getIntent().getStringExtra("key_password");

        uname.setText(user_name);
        upass.setText(user_password);


        btn_Switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this, MainActivity.class);
                intent.putExtra("password", "default_user_ID");
                intent.putExtra("user", "default_user_name");
                intent.putExtra("key_id", "user_key");
                startActivity(intent);
//                jumpToFirstActivity();
            }
        });

    }

    
    private void jumpToFirstActivity() {
        Intent mIntent = new Intent(this, MainActivity.class);
        mIntent.putExtra("password", "default_user_ID");
        mIntent.putExtra("user", "default_user_name");
        mIntent.putExtra("key_id", "user_key");
        setResult(RESULT_OK, mIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        jumpToFirstActivity();
    }


}