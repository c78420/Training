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
    	
    	Button btn1 = (Button) view.findViewById(R.id.button1);
    	btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
		        SharedPreferences.Editor editor = sharedPref.edit();
		        editor.putString("accont", accontEdt.getText().toString());
		        editor.putString("password", passwordEdt.getText().toString());
		        editor.commit();
		        
		        MyDBHelper mDbHelper = new MyDBHelper(getActivity());
		        SQLiteDatabase db = mDbHelper.getWritableDatabase();
		        Cursor cursor = db.query("acInforDB", new String[] {"id", "account", "password"}, null, null, null, null, null);
		        ContentValues cv = new ContentValues();
		        cv.put("account", accontEdt.getText().toString());
                cv.put("password", passwordEdt.getText().toString());
		        if (cursor.getCount()==0) {
		            cv.put("id", 1);
	                db.insert("acInforDB", null, cv);
                }
		        else {
		            db.update("acInforDB", cv, "id=1", null);
                }

				FragmentManager fragmentManager = getFragmentManager();
		    	FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		    	IsLoginFragment f = new IsLoginFragment();
		    	fragmentTransaction.replace(R.id.login_page, f);
		    	fragmentTransaction.addToBackStack(null);
		    	fragmentTransaction.commit();
			}
		});
    	
    	Button btn2 = (Button) view.findViewById(R.id.button2);
    	btn2.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
        return view;
    }
}
