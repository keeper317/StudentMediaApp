
package edu.calu.sai.studentmedia;


import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Paper extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.paper);
	}

	public void back(View v)
	{
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}

	public void go (View v)
	{
	    String fileUrl = "http://158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf";
	    String fileName = "2-2-18.pdf";

        new DownloadFile().execute(fileUrl, fileName);






    }



}
