package com.exa.osis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Teacher_home extends Activity {
	Button ad,um,lo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_home);
		ad =(Button) findViewById(R.id.button1);
		ad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Teacher_home.this,Addattendence.class);
				startActivity(i);
				
			}
		});
		 um=(Button) findViewById(R.id.button2);
		um.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Teacher_home.this,UM.class);
				startActivity(u);
				
			}
		});
		lo=(Button) findViewById(R.id.button3);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent b=new Intent(Teacher_home.this,Home.class);
				startActivity(b);
				
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Press Logout Button", Toast.LENGTH_SHORT).show();
	}
	

		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.teacher_home, menu);
		return true;
	}

}
