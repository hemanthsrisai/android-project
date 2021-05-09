package com.exa.osis;

import java.text.DateFormat;
import java.util.Calendar;


import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Addattendence extends Activity implements View.OnClickListener{
	DateFormat formats=DateFormat.getDateInstance();
	Calendar calendar=Calendar.getInstance();
	TextView text;
	Button btn,dto,sub;
	TextView id;
	SQLiteDatabase p;
	EditText gn,gid,gp,ge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addattendence);
		final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
		id=(TextView)findViewById(R.id.textView2);
		id.setText(globalvariabel.GetUsername().toString());
		gn=(EditText)findViewById(R.id.editText1);
		gid=(EditText)findViewById(R.id.editText2);
		gp=(EditText)findViewById(R.id.editText3);
		ge=(EditText)findViewById(R.id.editText4);

		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(this);
		updateDate();
		dto=(Button)findViewById(R.id.button3);
		dto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setDate2();
				updateDate2();
				
			}
		});
	sub=(Button)findViewById(R.id.button2);
	p=openOrCreateDatabase("pjr", Context.MODE_PRIVATE, null);
	p.execSQL("create table if not exists addattend(gn varchar,frmd vachar,tod varchar, gid varchar,gp varchar,ge varchar);");
	sub.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(gn.getText().toString().trim().length()==0 ||gid.getText().toString().trim().length()==0 ||gp.getText().toString().trim().length()==0 ||ge.getText().toString().trim().length()==0 )
			{
				Toast.makeText(Addattendence.this,"unsucess", Toast.LENGTH_SHORT).show();
				return;
			}
			p.execSQL("insert into addattend values('"+ gn.getText()+"','"+ btn.getText()+"','"+ dto.getText()+"','"+ gid.getText()+"','"+ gp.getText()+"','"+ ge.getText()+"');");
			Toast.makeText(Addattendence.this,"ADDED Successfully", Toast.LENGTH_SHORT).show();
			clr();
			
		}
	});
	
	}
	public void updateDate(){
		btn.setText(formats.format(calendar.getTime()));
	}
	public void updateDate2(){
		dto.setText(formats.format(calendar.getTime()));
	}
	public void setDate(){
		new DatePickerDialog(Addattendence.this,d,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
		
	}
	public void setDate2(){
		new DatePickerDialog(Addattendence.this,d2,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
		
	}
	DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() { 
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			calendar.set(Calendar.YEAR,year);
			calendar.set(Calendar.MONTH,monthOfYear);
			calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
			updateDate();
	
			
		}
	};
	DatePickerDialog.OnDateSetListener d2=new DatePickerDialog.OnDateSetListener() { 
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			calendar.set(Calendar.YEAR,year);
			calendar.set(Calendar.MONTH,monthOfYear);
			calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
			updateDate2();
			
		}
	};

	public void onClick(View v)
	{
		setDate();
	
	}
	public void clr()
	{
		gn.setText("");
		gid.setText("");
		gp.setText("");
		ge.setText("");
	}
	

}

	


