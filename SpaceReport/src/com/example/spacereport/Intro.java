package com.example.spacereport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class Intro extends Activity {

	protected void onCreate(Bundle instancia) {
		super.onCreate(instancia);
        setContentView(R.layout.intro);
        Thread timer = new Thread(){
        		public void run(){
        			try{
        				sleep(3500);
        			}catch(InterruptedException e){
        				e.printStackTrace();
        			}finally{
        				Intent openMainActivity = new Intent("com.example.spacereport.MAINACTIVITY");
        				startActivity(openMainActivity);
        					
        			}
        		}
        };
        timer.start();
	}
	protected void onPause(){
		super.onPause();
		finish();
	}
}
