package com.example.message_reading;



import java.util.Arrays;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

	

public class MainActivity extends Activity implements OnClickListener {

	Button quit,mes;
	TextView display;
	Thread thread = null;
	String sms="";
	String sentence;
	String words[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		quit = (Button) findViewById (R.id.bQuit);
		mes = (Button) findViewById (R.id.bView);
		display = (TextView) findViewById (R.id.tvMax);
		quit.setOnClickListener(this);
		mes.setOnClickListener(this);	
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}



	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.bView:
			
			
			
			
			Uri uri = Uri.parse("content://sms/inbox");
			Cursor cur = getContentResolver().query(uri, null, null, null,null);
			while (cur.moveToNext()) {
		          sms = sms + cur.getString(11); 
			}   
		
			
		          
		          words = sms.split(" ");		    
		          
		          List<String> list = Arrays.asList(words);
		          int counter = 0;
		          String mostFrequentWord = "";
		          
		          for (String streamed : list) {
		              if (streamed.equals(mostFrequentWord)) {
		                  counter++;
		              } else if (counter == 0) {
		                  mostFrequentWord = streamed;
		                  counter = 1;
		              } else {
		                  counter--;
		              }
		          }
		          display.setText(mostFrequentWord) ;
		          
		          
		          
		          
			break;
		
	case R.id.bQuit:
		super.finish();
			break;
		}
		
	}
	
	
}
