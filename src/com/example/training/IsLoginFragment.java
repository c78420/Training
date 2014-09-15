package com.example.training;

import android.app.Fragment;
import android.app.FragmentManager;
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
import android.widget.TextView;

public class IsLoginFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	    View view = inflater.inflate(R.layout.islogon_page, container, false);
	    Button btn = (Button) view.findViewById(R.id.button1);
	    btn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
            }
        });
	    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
	    TextView sharedPrefAccontTxt = (TextView) view.findViewById(R.id.textView3);
	    sharedPrefAccontTxt.setText(sharedPref.getString("accont", ""));
	    TextView sharedPrefPasswordTxt = (TextView) view.findViewById(R.id.textView5);
	    sharedPrefPasswordTxt.setText(sharedPref.getString("password", ""));
	    
	    MyDBHelper mDbHelper = new MyDBHelper(getActivity());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor cursor = db.query("acInforDB", new String[] {"id", "account", "password"}, null, null, null, null, null);
        cursor.moveToLast();
	    TextView sqlAccontTxt = (TextView) view.findViewById(R.id.textView9);
	    sqlAccontTxt.setText(cursor.getString(1));
        TextView sqlPasswordTxt = (TextView) view.findViewById(R.id.textView11);
        sqlPasswordTxt.setText(cursor.getString(2));
	    
		return view;
	}
}
