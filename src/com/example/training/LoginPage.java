package com.example.training;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {
    
    private String account = null;
    private String password = null;
    private EditText accountEdt = null;
    private EditText passwordEdt = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        
        accountEdt = (EditText) findViewById(R.id.editText1);
        passwordEdt = (EditText) findViewById(R.id.editText2);
        
        Button cancelBtn = (Button) findViewById(R.id.button2);
        cancelBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish(2);
            }
        });
        Button signInBtn = (Button) findViewById(R.id.button1);
        signInBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                finish(1);
            }
        });
    }
    
    public void finish(int a) {
        // TODO Auto-generated method stub
        Intent responseIntent = new Intent();
        responseIntent.putExtra("account", accountEdt.getText().toString());
        responseIntent.putExtra("password", passwordEdt.getText().toString());
        if (a == 1) {
            setResult(RESULT_OK, responseIntent);
        }
        else {
            setResult(RESULT_CANCELED, responseIntent);
        }
        super.finish();
    }
}
