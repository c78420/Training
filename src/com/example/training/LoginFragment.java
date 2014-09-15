package com.example.training;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	View view = inflater.inflate(R.layout.login_page, container, false);
    	
    	final EditText accontEdt = (EditText) view.findViewById(R.id.editText1);
    	final EditText passwordEdt = (EditText) view.findViewById(R.id.editText2);
    	
    	// 登入
    	Button btn1 = (Button) view.findViewById(R.id.button1);
    	btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    SharedPref sharedPref = new SharedPref();
			    String[] sharedPrefData = sharedPref.load(getActivity());
			    String sharedPrefAccontStr = sharedPrefData[0];
			    String sharedPrefPasswordStr = sharedPrefData[1];
		        
		        MyDBHelper mDbHelper = new MyDBHelper(getActivity());
		        String[] sqlData = mDbHelper.GetDatabase();
		        String sqlAccontStr = sqlData[0];
		        String sqlPasswordStr = sqlData[1];
		        
		        if (sharedPrefAccontStr.equals(accontEdt.getText().toString()) && 
		            sharedPrefPasswordStr.equals(passwordEdt.getText().toString()) && 
		            sqlAccontStr.equals(accontEdt.getText().toString()) && 
		            sqlPasswordStr.equals(passwordEdt.getText().toString())) {
		            
		            FragmentManager fragmentManager = getFragmentManager();
	                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
	                IsLoginFragment f = new IsLoginFragment();
	                fragmentTransaction.replace(R.id.login_page, f, "btn1");
	                fragmentTransaction.addToBackStack(null);
	                fragmentTransaction.commit();
                }
		        else {
		            Toast.makeText(getActivity(), "登入失敗", Toast.LENGTH_SHORT).show();
                }
			}
		});
    	// 取消
    	Button btn2 = (Button) view.findViewById(R.id.button2);
    	btn2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    	// 註冊
    	Button btn3 = (Button) view.findViewById(R.id.button3);
    	btn3.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (isError(accontEdt.getText().toString()) && isError(passwordEdt.getText().toString())) {
                    Toast.makeText(getActivity(), "註冊失敗", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPref sharedPref = new SharedPref();
                    sharedPref.save(getActivity(), accontEdt.getText().toString(), passwordEdt.getText().toString());
                    
                    MyDBHelper mDbHelper = new MyDBHelper(getActivity());
                    if (mDbHelper.getCursorCount()==0) {
                        mDbHelper.InsertDatabase(accontEdt.getText().toString(), passwordEdt.getText().toString());
                    }
                    else {
                        mDbHelper.UpdateDatabase(accontEdt.getText().toString(), passwordEdt.getText().toString());
                    }
                    Toast.makeText(getActivity(), "註冊成功", Toast.LENGTH_SHORT).show();
                }
            }
        });
    	
        return view;
    }
    
    private boolean isError(String data) {
        if (data == null) {
            return true;
        }
        data.trim();
        if (data.equals("")) {
            return true;
        }
        return false;
    }
}
