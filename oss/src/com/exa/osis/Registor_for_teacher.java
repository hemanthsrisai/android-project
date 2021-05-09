package com.exa.osis;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registor_for_teacher extends Activity {
	EditText Tname,Tid,Temail,Tphonenumber,Taddress,Tdepartment,Tpassword;
	SQLiteDatabase db;
	Button Reg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registor_for_teacher);

		db=openOrCreateDatabase("OSIS", Context.MODE_PRIVATE, null);
		db.execSQL("create table if not exists TReg(Tname varchar,Tid varchar,Temail varchar,Tphonenumber varchar,Taddress varchar, Tdepartment varchar, Tpassword varchar)");
		
		Tname=(EditText)findViewById(R.id.editText1);
		Tid=(EditText)findViewById(R.id.editText5);
		Temail=(EditText)findViewById(R.id.editText2);
		Tphonenumber=(EditText)findViewById(R.id.editText3);
		Taddress=(EditText)findViewById(R.id.editText4);
		Tdepartment=(EditText)findViewById(R.id.editText6);
		Tpassword=(EditText)findViewById(R.id.editText7);
		Reg= (Button) findViewById(R.id.button1);
        
		Reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(Tname.getText().toString().trim().length()==0||Tid.getText().toString().trim().length()==0||Temail.getText().toString().trim().length()==0||Tphonenumber.getText().toString().trim().length()==0||Taddress.getText().toString().trim().length()==0||Tdepartment.getText().toString().trim().length()==0)
				{
					Toast.makeText(Registor_for_teacher.this, "please enter all the values", Toast.LENGTH_LONG).show();
					return;
				}
				else if(Tphonenumber.getText().toString().trim().length()!=10)
				{
					Toast.makeText(Registor_for_teacher.this,"please enter a valid phone no.", Toast.LENGTH_LONG).show();
					return;
				}
				db.execSQL("insert into TReg values('"+Tname.getText()+"','"+Tid.getText()+"','"+Temail.getText()+"','"+Tphonenumber.getText()+"','"+Taddress.getText()+"','"+Tdepartment.getText()+"','"+Tpassword.getText()+"')");
				{
					Toast.makeText(Registor_for_teacher.this,"Registration Successfully Done", Toast.LENGTH_SHORT).show();
					clrscr();

				}
			}
		});
	}     
	public void clrscr()
	{
		Tname.setText("");
		Temail.setText("");
		Tid.setText("");
		Tpassword.setText("");
		Tphonenumber.setText("");
		Taddress.setText("");
		Tdepartment.setText("");
	}

}

		
