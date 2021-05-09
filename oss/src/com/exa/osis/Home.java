 package com.exa.osis;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends Activity {
	Button reg,stu,log;
	SQLiteDatabase db;
	EditText uname,pwd;
	String uvalue,pvalue;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		db=openOrCreateDatabase("OSIS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists SReg(ename varchar,erollno varchar,email varchar,phonenumber varchar,address varchar, department varchar, password varchar)");
		db.execSQL("create table if not exists TReg(Tname varchar,Tid varchar,Temail varchar,Tphonenumber varchar,Taddress varchar, Tdepartment varchar, Tpassword varchar)");
		
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();



		uname= (EditText) findViewById(R.id.editText1);
		pwd= (EditText) findViewById(R.id.editText2);
		reg =(Button) findViewById(R.id.button2);
		reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Home.this,Registor_for_teacher.class);
				startActivity(i);
				
			}
		});
		stu=(Button) findViewById(R.id.button3);
		stu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent u=new Intent(Home.this,Registor.class);
				startActivity(u);
				
			}
		});
		log=(Button) findViewById(R.id.button1);
		
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(uname.getText().toString().trim().length()==0||pwd.getText().toString().trim().length()==0)
				{
					Toast.makeText(Home.this, "ENTER LOGIN DETAILS", Toast.LENGTH_LONG).show();
					return;
				}
				uvalue=uname.getText().toString();
				pvalue=pwd.getText().toString();
				
				if(uvalue.equals("admin")&&pvalue.equals("123"))
				{	
					scan g=new scan();
					g.execute();
					Toast.makeText(Home.this,"WELCOME ADMIN", Toast.LENGTH_SHORT).show();
					
					Intent i= new Intent(Home.this,Admin.class);
					startActivity(i);
					return;
				}
				Cursor c= db.rawQuery("select * from SReg where erollno='"+uname.getText()+"' and password='"+pwd.getText()+"'", null);
				
				if(c.moveToFirst() )
				{
					scan g=new scan();
					g.execute();
                    Toast.makeText(Home.this,"WELCOME USER", Toast.LENGTH_SHORT).show();
                    globalvariabel.Setusername(uname.getText().toString());

					Intent b= new Intent(Home.this,Student_Home.class);
					startActivity(b);
					
					return;
				}
				
				if (uvalue.equals("teacher")&&pvalue.equals("1234"))
				{
					scan g=new scan();
					g.execute();
                    Toast.makeText(Home.this,"WELCOME USER", Toast.LENGTH_SHORT).show();
                    globalvariabel.Setusername(uname.getText().toString());
                    
					Intent k= new Intent(Home.this,Teacher_home.class);
					startActivity(k);
					return;	
				}
				else
				{
					Toast.makeText(Home.this,"ENTER VALID LOGIN DETAILS" , Toast.LENGTH_SHORT).show();
					return;
				}
				
			}

			
		});
	}

	public class scan extends AsyncTask<String, String, String>{

		private ProgressDialog pd;

		protected void onPreExecute() {
			super.onPreExecute();
		 pd = new ProgressDialog(Home.this);
		 pd.setTitle("Please Wait!!");
		 pd.setMessage("Logging you In....");
		 pd.setMax(10);
		 pd.show();
		}
	
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	}

