package com.ekd.data_transfer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 1;
    private final String TAG = "";
    private EditText editText1, editText2;
    private TextView unique_text;
    private Button btn_Switch1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Switch1 = findViewById(R.id.btn1_Switch);
        editText1 = findViewById(R.id.edit_text_u);
        editText2 = findViewById(R.id.edit_text_pass);
        unique_text = findViewById(R.id.unique_id);


        initView();
        String unique_id = getIntent().getStringExtra("key_id");
        String user = getIntent().getStringExtra("user");
        String pass = getIntent().getStringExtra("password");
        editText1.setText(user);
        editText2.setText(pass);
        unique_text.setText(unique_id);

    }


    private void initView() {
        btn_Switch1.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1_Switch:
                jumpToSecondActivity();
                break;
        }
    }


    private void jumpToSecondActivity(){
                String user_name = editText1.getText().toString().trim();
                String user_password = editText2.getText().toString();

                if(TextUtils.isEmpty(user_name)){
                    Toast.makeText(MainActivity.this, "Please Input your user name", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(user_password)){
                    Toast.makeText(MainActivity.this, "Please Input your password", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    Toast.makeText(MainActivity.this, "Good! Transferring data...", Toast.LENGTH_SHORT).show();
//                    return;
                }

                Intent mIntent = new Intent(MainActivity.this, Second_Activity.class);
//                Intent i = new Intent(this, SecondActivity.class);

                mIntent.putExtra("key_user", user_name);
                mIntent.putExtra("key_password", user_password);
                startActivity(mIntent);


    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, "onSaveInstanceState:");
    }


}