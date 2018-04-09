package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class Home extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		//check for the WRITE EXTERNAL PERMISSION
		if (ContextCompat.checkSelfPermission(this,
				Manifest.permission.WRITE_EXTERNAL_STORAGE)
				!= PackageManager.PERMISSION_GRANTED)
		{
			//ask for WRITE_EXTERNAL_PERMISSION
			ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
					1);
		}
	}
	public void menu(View v)
	{
		//added a change to commit.
	}

	public void paper(View v)
	{
		Intent intent = new Intent(this, Paper.class);
		startActivity(intent);
	}

	public void tv(View v)
	{
		Intent intent = new Intent(this, TV.class);
		startActivity(intent);
	}
	public void radio(View v)
	{
		Intent intent = new Intent(this, Radio.class);
		startActivity(intent);
	}

	public void lab(View v)
	{
		//Intent intent = new Intent(this, Lab.class);
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://orgsync.com/60371/chapter"));
		startActivity(intent);
	}
}