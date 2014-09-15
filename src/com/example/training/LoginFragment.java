package com.example.training;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

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
    	Button btn = (Button) view.findViewById(R.id.button1);
    	btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
		    	FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		    	IsLoginFragment f = new IsLoginFragment();
		    	fragmentTransaction.replace(R.id.main_activity, f);
//		    	fragmentTransaction.addToBackStack(null);
		    	fragmentTransaction.commit();
			}
		});
        return view;
    }
}
