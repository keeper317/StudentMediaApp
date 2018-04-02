
package edu.calu.sai.studentmedia;


import android.content.Intent;
import android.net.Uri;
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
		Uri pdfUri;
	    String fileUrl = "http://158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf";
	    String fileName = "/2-2-18.pdf";
        final String AUTH = BuildConfig.APPLICATION_ID;

		//if(Build.VERSION.SDK_INT>22){
			//prompt user for storage permission

		//}

        new DownloadFile().execute(fileUrl, fileName);


		/*
		File pdfFile = new File(Environment.getExternalStorageDirectory()
				+ "/StudentMediaApp/Paper" + fileName);  // -> filename = 2-2-18.pdf

		pdfUri = FileProvider.getUriForFile(this,AUTH + ".provider", pdfFile);

		Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
		pdfIntent.setDataAndType(pdfUri, "StudentMediaApp/Paper");
		pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

		try{
			startActivity(pdfIntent);
		}catch(ActivityNotFoundException e){
			Toast.makeText(getApplicationContext(),
					"No Application available to view PDF ", Toast.LENGTH_SHORT).show();
		}*/




                            

    }



}
