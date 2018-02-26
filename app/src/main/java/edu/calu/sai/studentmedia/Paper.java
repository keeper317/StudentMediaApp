
package edu.calu.sai.studentmedia;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import android.os.Environment;

import android.widget.Toast;

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

	public void go (View v)
	{
	    String fileUrl = "//158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf";
	    String fileName = "2-2-18.pdf";

        File file = new File("/root/sdcard", "/TESTTEST");
        if (!file.mkdirs()) {
            Toast.makeText(this, "NOT CREATED", Toast.LENGTH_SHORT).show();
        }


        //new DownloadFile().execute(fileUrl, fileName);



    }



}
//158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf