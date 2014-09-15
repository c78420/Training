package com.example.training;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
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
	    SharedPref sharedPref = new SharedPref();
        String[] sharedPrefData = sharedPref.load(getActivity());
	    TextView sharedPrefAccontTxt = (TextView) view.findViewById(R.id.textView3);
	    sharedPrefAccontTxt.setText(sharedPrefData[0]);
	    TextView sharedPrefPasswordTxt = (TextView) view.findViewById(R.id.textView5);
	    sharedPrefPasswordTxt.setText(sharedPrefData[1]);
	    
	    MyDBHelper mDbHelper = new MyDBHelper(getActivity());
	    String[] data = mDbHelper.GetDatabase();
	    TextView sqlAccontTxt = (TextView) view.findViewById(R.id.textView9);
	    sqlAccontTxt.setText(data[0]);
        TextView sqlPasswordTxt = (TextView) view.findViewById(R.id.textView11);
        sqlPasswordTxt.setText(data[1]);
	    
		return view;
	}
}
