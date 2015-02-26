package com.example.datatimepickerexample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView date = (TextView) findViewById(R.id.date_text_view);
        final Button dateButton = (Button) findViewById(R.id.date_button);
        dateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			 	final OnDateSetListener onDateSetListener = new OnDateSetListener() {
		        	@Override
		        	public void onDateSet(DatePicker view, int year, int monthOfYear,
		        			int dayOfMonth) {
		        		Calendar cal = Calendar.getInstance();
		        		cal.set(year, monthOfYear, dayOfMonth);
		        		date.setText(formatDate(cal.getTime()));
		        	}
		        };
		        Calendar c = Calendar.getInstance();
		      	new DatePickerDialog(MainActivity.this, onDateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
        
        final TextView time = (TextView) findViewById(R.id.time_text_view);
        final Button timeButton = (Button) findViewById(R.id.time_button);
        timeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			 	final OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
						
						@Override
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							time.setText(String.format("%1s:%2s", hourOfDay, minute));
							
						}
					};
				Calendar c = Calendar.getInstance();
		        new TimePickerDialog(MainActivity.this, onTimeSetListener, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true).show();
			}
		});
        
    }
    
    private String formatDate(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	return sdf.format(date);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
