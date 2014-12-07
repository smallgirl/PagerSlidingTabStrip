package com.example.pagerslidingtabstrip;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @Description: 
 * @author admin
 * @date 2014-11-1 上午11:19:26
 * @version V1.0
 */

@SuppressLint("ValidFragment")
public class FragmentTest extends Fragment {

	
	private Context context;
	private View rootView;
	
	private TextView textView;
	private int num;
	public FragmentTest(Context context,int num) {
		this.context = context;
		this.num =num;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (rootView == null) {
			
			rootView = inflater.inflate(R.layout.test,
					container, false);
			textView = (TextView) rootView.findViewById(R.id.tv);
			textView.setText(String.valueOf(num));
		}
        
		ViewGroup parent = (ViewGroup) rootView.getParent();
		
		if (parent != null) {
			parent.removeView(rootView);
		}
		return rootView;
	}

	

}
