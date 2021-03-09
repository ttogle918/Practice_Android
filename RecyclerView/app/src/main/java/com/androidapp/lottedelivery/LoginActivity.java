package com.androidapp.lottedelivery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edit_Id;
    private EditText edit_password;
    private Button btn_login;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        // Set up the login form.

        edit_Id = (EditText) findViewById(R.id.edit_id);
        edit_password = (EditText) findViewById(R.id.edit_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        setListener();

    }

    private void setListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                Intent newintent = new Intent();
                newintent.putExtra("activity", "loginActivity");
                setResult(RESULT_OK, newintent);
                finish();
            }
        });
    }


}