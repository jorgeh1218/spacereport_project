package com.example.spacereport;


import static org.junit.Assert.assertTrue;

import java.util.Collection;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

import android.view.View;
import java.lang.Object;



import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageButton upload;
	EditText nameText,cedulaText,solText;
	Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.editText1); 
        cedulaText = (EditText) findViewById(R.id.editText2);
        solText = (EditText) findViewById(R.id.editText3);
       
        
        upload = (ImageButton) findViewById(R.id.upload);
        upload.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(nameText.getText().length()==0 || cedulaText.getText().length()==0 || solText.getText().length()==0) // Si algun campo de texto esta vacio, error
					showDialogOperation("Datos incompletos");
				else{
					new ExecuteNetworkOperation(MainActivity.this).execute(nameText.getText().toString(),cedulaText.getText().toString(),
							solText.getText().toString());
					nameText.setText("");
					cedulaText.setText("");
					solText.setText("");// Limpia los campos de texto
				}
					
			}
        });
    }
    public void showDialogOperation(String a) // Metodo que permite mostrar popup con la cadena enviada
    {
    	AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle("Error");
		alertDialog.setMessage(a);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int which) {
		      // TODO Add your code for the button here.
		   }
		});
		// Set the Icon for the Dialog
		alertDialog.show();
    }
    
}
