package com.exa.osis;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Student_Home extends Activity {
	Button vp,lo,ck,et;
	SQLiteDatabase db;
	TextView uid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student__home);
		vp =(Button) findViewById(R.id.button1);
		
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		uid=(TextView)findViewById(R.id.textView2);
		uid.setText(globalvariabel.GetUsername().toString());


		db=openOrCreateDatabase("OSIS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists SReg(ename varchar,erollno varchar,email varchar,phonenumber varchar,address varchar, department varchar, password varchar)");
		
		

		vp.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						Cursor c=db.rawQuery("select * from  SReg where erollno='"+uid.getText()+"'",null);
						if(c.getCount()==0)
						{
							showMessage("Error", "No data found");
							return;
						}
						
						StringBuffer buffer=new StringBuffer();
						while(c.moveToNext())
						{
						 buffer.append("Name:"+c.getString(0)+"\n");
						 buffer.append("RollNo:"+c.getString(1)+"\n");
						 buffer.append("E-mail:"+c.getString(2)+"\n");
						 buffer.append("Phone:"+c.getString(3)+"\n");
						 buffer.append("Address:"+c.getString(4)+"\n");
						 buffer.append("Dept:"+c.getString(5)+"\n");
						 buffer.append("Password:"+c.getString(6)+"\n");
						}
						showMessage("My Profile", buffer.toString());
					}
				});
		lo=(Button) findViewById(R.id.button4);
		lo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Student_Home.this,Home.class);
				startActivity(u);
	
		
			}
		});
		ck=(Button) findViewById(R.id.button5);
		ck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Student_Home.this,Checkattendence.class);
				startActivity(u);
	
		
			}
		});
		et=(Button) findViewById(R.id.button3);
		et.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Student_Home.this,ET.class);
				startActivity(u);
	
		
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Press Logout Button", Toast.LENGTH_SHORT).show();
	}
	
	public void showMessage(String title,String message)
	{
		Builder builder=new Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();
		
	}
			}
