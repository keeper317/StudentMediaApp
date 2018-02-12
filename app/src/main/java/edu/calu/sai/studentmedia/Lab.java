package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Lab extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lab);
	}

	public void back(View v)
	{
		Intent intent = new Intent(this, Home.class);
		startActivity(intent);
	}
}
