
package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Paper extends AppCompatActivity
{
	String[] paths = {"2-2-18.pdf"};
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

	public void go(View v)
	{
		Intent i = new Intent(this, Viewer.class);
		i.putExtra("Path", paths[0]);
		startActivity(i);
	}
}
