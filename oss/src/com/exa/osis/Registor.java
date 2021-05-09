package com.exa.osis;

import java.security.PublicKey;

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
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registor extends Activity {
	EditText ename,eroll_no,email,phonenumber,address,department,password;
	SQLiteDatabase db;
	Button Reg;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registor);
		
		db=openOrCreateDatabase("OSIS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists SReg(ename varchar,erollno varchar,email varchar,phonenumber varchar,address varchar, department varchar, password varchar)");
	
		ename=(EditText)findViewById(R.id.editText1);
		eroll_no=(EditText)findViewById(R.id.editText5);
		email=(EditText)findViewById(R.id.editText2);
		phonenumber=(EditText)findViewById(R.id.editText3);
		address=(EditText)findViewById(R.id.editText4);
		department=(EditText)findViewById(R.id.editText6);
		password=(EditText)findViewById(R.id.editText7);
		Reg= (Button) findViewById(R.id.button1);
		
		Reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ename.getText().toString().trim().length()==0||eroll_no.getText().toString().trim().length()==0||email.getText().toString().trim().length()==0||phonenumber.getText().toString().trim().length()==0||address.getText().toString().trim().length()==0||department.getText().toString().trim().length()==0)
				{
					Toast.makeText(Registor.this, "please enter all the values", Toast.LENGTH_LONG).show();
					return;
				}
				else if(phonenumber.getText().toString().trim().length()!=10)
				{
					Toast.makeText(Registor.this,"please enter a valid phone no.", Toast.LENGTH_LONG).show();
					return;
				}
				db.execSQL("insert into SReg values('"+ename.getText()+"','"+eroll_no.getText()+"','"+email.getText()+"','"+phonenumber.getText()+"','"+address.getText()+"','"+department.getText()+"','"+password.getText()+"')");
				{
					Toast.makeText(Registor.this,"Registration Successfully Done", Toast.LENGTH_SHORT).show();
					clrscr();

				}
			}
		});
		
	
	}
		
		public void clrscr()
		{
			ename.setText("");
			email.setText("");
			eroll_no.setText("");
			password.setText("");
			phonenumber.setText("");
			address.setText("");
			department.setText("");
		}

}
		
			
	

	
	
		
       
        

