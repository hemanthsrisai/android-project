package com.exa.osis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends Activity {
	Button reg,stu,lo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		stu=(Button) findViewById(R.id.button1);
		stu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Admin.this,Registor.class);
				startActivity(u);
				
			}
		});
		reg =(Button) findViewById(R.id.button2);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Admin.this,Registor_for_teacher.class);
				startActivity(i);
				
			}
		});
		lo=(Button) findViewById(R.id.button3);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent z=new Intent(Admin.this,Home.class);
				startActivity(z);
				
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Press Logout Button", Toast.LENGTH_SHORT).show();
	}
	

		
		
		}
	





			
			
        
        
     
    
      
