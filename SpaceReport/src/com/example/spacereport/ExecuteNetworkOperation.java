package com.example.spacereport;

import java.util.Collection;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class ExecuteNetworkOperation extends AsyncTask<String, Void, String>{
	AlertDialog alertDialog;
	private Context cont;
   public ExecuteNetworkOperation(Context ctx)
   {
	   cont=ctx;
   }
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        /**
         * show dialog
         */
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... arg0) {
        try
        {
    	Person person = new Person(arg0[0],arg0[1], arg0[2]); //Crea la persona con los campos de texto ingresados
    	PersonSvcApi api = new RestAdapter.Builder()
    							.setEndpoint("http://186.95.195.89:8080") // Direccion del servidor
    							.setLogLevel(LogLevel.FULL)
    							.build().create(PersonSvcApi.class);	//Crea la conexion
    	
		api.addPerson(person); //Agrega la persona
		boolean ok = api.addPerson(person);
		return "0";
        }
        catch(Exception e)
        {
        	return "e";
        }
		
    }

    @Override
    protected void onPostExecute(String result) { // Ejecuta popup de exito o fracaso
        // TODO Auto-generated method stub
        /**
         * update ui thread and remove dialog
         */
    	if(result=="e")
    	{
	    	AlertDialog alertDialog = new AlertDialog.Builder(cont).create();
			alertDialog.setTitle("Error");
			alertDialog.setMessage("Error al enviar datos. Intente mas tarde");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			   public void onClick(DialogInterface dialog, int which) {
			      // TODO Add your code for the button here.
			   }
			});
			alertDialog.show();
    	}
    	else
    	{
    		AlertDialog alertDialog = new AlertDialog.Builder(cont).create();
			alertDialog.setTitle("Resultado");
			alertDialog.setMessage("Reporte enviado");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			   public void onClick(DialogInterface dialog, int which) {
			      // TODO Add your code for the button here.
			   }
			});
			alertDialog.show();
    	}
    	
    }

}

