package com.example.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    
    private TextView accountTxt = null;
    private TextView passwordTxt = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "toast", Toast.LENGTH_SHORT).show();
            }
        });
        
        ImageView img = (ImageView) findViewById(R.id.imageView1);
        img.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(getBaseContext(), LoginPage.class);
                startActivityForResult(nextIntent, 1);
            }
        });
        
        accountTxt = (TextView) findViewById(R.id.textView6);
        passwordTxt = (TextView) findViewById(R.id.textView4);
        
        Button fragmentBtn = (Button)findViewById(R.id.button2);
        fragmentBtn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                LoginFragment f = new LoginFragment();          
                fragmentTransaction.add(R.id.main_activity, f);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String account = data.getStringExtra("account");
            accountTxt.setText(account);
            String password = data.getStringExtra("password");
            passwordTxt.setText(password);
        }
        else {
            accountTxt.setText("");
            passwordTxt.setText("");
            Toast.makeText(getApplicationContext(), "尚未登入", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
