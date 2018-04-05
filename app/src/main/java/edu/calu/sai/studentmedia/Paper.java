
package edu.calu.sai.studentmedia;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


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
		Uri pdfUri;
	    String fileUrl = "http://158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf";
	    String fileName = "/2-2-18.pdf";
        final String AUTH = BuildConfig.APPLICATION_ID;



            File pdfFile = new File(Environment.getExternalStorageDirectory()
		                                    + "/StudentMediaApp/Paper" + fileName);  // -> filename = 2-2-18.pdf
			if(!pdfFile.exists())
            new DownloadFile().execute(fileUrl, fileName);




            pdfUri = FileProvider.getUriForFile(this, AUTH + ".provider", pdfFile);

            final Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(pdfUri, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            System.out.println("Path : " + Environment.getExternalStorageDirectory());

		Timer timer = new Timer();

		TimerTask delayedThreadStartTask = new TimerTask() {
			@Override
			public void run() {

				//captureCDRProcess();
				//moved to TimerTask
				new Thread(new Runnable() {
					@Override
					public void run() {

						try {
							startActivity(pdfIntent);
						} catch (ActivityNotFoundException e) {
							Toast.makeText(getApplicationContext(),"No Application available to view PDF ",
							               Toast.LENGTH_SHORT).show();
						}
					}
				}).start();
			}
		};

		timer.schedule(delayedThreadStartTask, 5 * 1000); //1 minute



    }





}
