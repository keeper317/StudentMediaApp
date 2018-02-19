
package edu.calu.sai.studentmedia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
		DownloadFile("158.83.1.59/StudentMediaApp/Paper/2-2-18.pdf");

		Uri path = Uri.fromFile(new File("file:///mnt/sdcard/Download/2-2-18.pdf"));
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(path, "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}

	public static void DownloadFile(String fileURL) {
		try {

			FileOutputStream f = new FileOutputStream(new File("/mnt/sdcard/Download/") );
			URL u = new URL(fileURL);
			HttpURLConnection c = (HttpURLConnection) u.openConnection();
			c.setRequestMethod("GET");
			c.setDoOutput(true);
			c.connect();

			InputStream in = c.getInputStream();

			byte[] buffer = new byte[1024];
			int len1 = 0;
			while ((len1 = in.read(buffer)) > 0) {
				f.write(buffer, 0, len1);
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
